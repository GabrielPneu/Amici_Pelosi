package com.fpt.petstore.controller;

import com.fpt.petstore.services.CookieService;
import com.fpt.petstore.services.AmiciPelosiService;
import com.fpt.petstore.util.DateUtil;
import com.fpt.petstore.util.StringUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpt.petstore.entities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/shop")
public class ProductController {
    private static final String CATEGORY_FOOD = "food";
    private static final String CATEGORY_PRODUCT = "toys-acessories";
    private static final String TITLE_PRODUCT = "Brinquedos e acessórios";
    private static final String TITLE_FOOD = "Rações e petiscos";
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private AmiciPelosiService amiciPelosiService;
    @Autowired
    private CookieService cookieService;
    @Autowired
    private JavaMailSender sender;

    @GetMapping("/{category}/{page}")
    public String viewProduct(@PathVariable(value = "category") String category, @PathVariable(value = "page") int page, ModelMap model, HttpSession session) {
        String listCartAsJson = cookieService.getValue("listCart", "");
        //if json list cart is empty
        if (!StringUtil.isEmpty(listCartAsJson) && session.getAttribute("listCart") == null) {
            Map<String, OrderItem> listCart = null;
            try {
                //decode json cookie and set to name session
                listCartAsJson = URLDecoder.decode(listCartAsJson, StandardCharsets.UTF_8.toString());
                //doc value json
                listCart = new ObjectMapper().readValue(listCartAsJson, new TypeReference<Map<String, OrderItem>>() {
                });
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }

            //set attribute session
            session.setAttribute("listCart", listCart);
        }
        //phan trang cho cart
        if (category.equalsIgnoreCase(CATEGORY_PRODUCT)) {

            Integer countproduct = amiciPelosiService.countProduct();

            Page<Product> listProductbyPage = amiciPelosiService.listProductbyPage(PageRequest.of(page - 1, ConstVariable.PRODUCTPERPAGE));

            List<Integer> listPage = amiciPelosiService.calculateTotalPage(countproduct, ConstVariable.PRODUCTPERPAGE);
            model.addAttribute("pageSize", listPage);
            model.addAttribute("listProduct", listProductbyPage.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("category", CATEGORY_PRODUCT);
            model.addAttribute("title", TITLE_PRODUCT);
            model.addAttribute("numberProduct", countproduct);
            model.addAttribute("productPerPage", ConstVariable.PRODUCTPERPAGE);

            if (page > listPage.size()) {
                return "error/404error";
            }
        } else {
            Integer countFood = amiciPelosiService.countFood();

            Page<Food> listFoodperPage = amiciPelosiService.listFoodPerPage(PageRequest.of(page - 1, ConstVariable.PRODUCTPERPAGE));

            List<Integer> listPage = amiciPelosiService.calculateTotalPage(countFood, ConstVariable.PRODUCTPERPAGE);
            model.addAttribute("pageSize", listPage);
            model.addAttribute("listProduct", listFoodperPage.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("category", CATEGORY_FOOD);
            model.addAttribute("title", TITLE_FOOD);
            model.addAttribute("numberProduct", countFood);
            model.addAttribute("productPerPage", ConstVariable.PRODUCTPERPAGE);
            if (page > listPage.size()) {
                return "/error/404error";
            }
        }

        return "product";
    }

    @GetMapping("/addtocart/{category}/{sortName}")
    public String addCart(@PathVariable("sortName") String sortName, @PathVariable("category") String category, HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttributes) throws URISyntaxException {
        String referer = request.getHeader("Referer");

        Product product = amiciPelosiService.getProductbySortName(sortName);
        Food food = amiciPelosiService.getFoodbySortName(sortName);
        //create map for session cart
        Map<String, OrderItem> listCart = (Map<String, OrderItem>) session.getAttribute("listCart");
        if (listCart == null) {
            listCart = new HashMap<>();
            session.setAttribute("listCart", listCart);
        }
        if (category.equalsIgnoreCase(CATEGORY_PRODUCT)) {
            //set cart
            if (listCart.get(product.getSortName()) != null) {
                OrderItem cart = listCart.get(product.getSortName());
                cart.setQuantity(cart.getQuantity() + 1);
                cart.setTotal(cart.getQuantity() * product.getPrice());
                listCart.put(product.getSortName(), cart);
            } else {
                OrderItem newCart = new OrderItem(product, product.getPrice());
                listCart.put(product.getSortName(), newCart);
            }
        } else {
            if (listCart.get(food.getSortName()) != null) {
                OrderItem cart = listCart.get(food.getSortName());
                cart.setQuantity(cart.getQuantity() + 1);
                cart.setTotal(cart.getQuantity() * food.getPrice());
                listCart.put(food.getSortName(), cart);
            } else {
                OrderItem newCart = new OrderItem(food, food.getPrice());
                listCart.put(food.getSortName(), newCart);
            }
        }
        session.setAttribute("listCart", listCart);

        redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "Adicionado ao carrinho");
        redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "sucesso");
        redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Sucesso");


        String listCartAsJson = "";

        try {
            //encoder json and write value as String to listcart
            listCartAsJson = URLEncoder.encode(new ObjectMapper().writeValueAsString(listCart), StandardCharsets.UTF_8.toString());

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        //create cookie
        cookieService.create("listCart", listCartAsJson, 24);

        return ConstVariable.redirectRefer + referer;
    }

    @PostMapping("/updateCart")
    public String updateCart(HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttributes) {

        String[] productSortNames = request.getParameterValues("productSortName");
        String[] foodSortNames = request.getParameterValues("foodSortName");
        String[] foodQuantity = request.getParameterValues("foodQuantity");
        String[] productQuantity = request.getParameterValues("productQuantity");

        Map<String, OrderItem> listCart = (Map<String, OrderItem>) session.getAttribute("listCart");
        if (listCart != null) {
            if (productSortNames != null) {
                for (int i = 0; i < productSortNames.length; i++) {
                    OrderItem cart = listCart.get(productSortNames[i]);
                    cart.setQuantity(Integer.parseInt(productQuantity[i]));
                    cart.setTotal(cart.getQuantity() * cart.getProduct().getPrice());
                }
            }

            if (foodSortNames != null) {
                for (int i = 0; i < foodSortNames.length; i++) {
                    OrderItem cart = listCart.get(foodSortNames[i]);
                    cart.setQuantity(Integer.parseInt(foodQuantity[i]));
                    cart.setTotal(cart.getQuantity() * cart.getFood().getPrice());
                }
            }

        }
        session.setAttribute("listCart", listCart);
        // Notificação JavaScript
        redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "Carrinho atualizado com sucesso");
        redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "sucesso");
        redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Sucesso");
        return ConstVariable.redirect + "cart";

    }

    @PostMapping("/checkout")
    public String checkOut(@RequestParam Map<String, String> map, HttpSession session, RedirectAttributes redirectAttributes) {
        final String CURRENCY = "R$";
        final String ORDER_PREFIX = "order_";

        // Validação inicial
        String transaction = map.get("transaction");
        if (transaction == null || transaction.isEmpty()) {
            redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "Escolha um método de pagamento");
            redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "error");
            redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Erro");
            return ConstVariable.redirect + "thanh-toan";
        }

        // Recuperação de informações da sessão
        Map<String, OrderItem> listCart = (Map<String, OrderItem>) session.getAttribute("listCart");
        Customer customerSession = (Customer) session.getAttribute("customer");

        if (listCart == null || listCart.isEmpty() || customerSession == null) {
            redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "Carrinho vazio ou sessão expirada");
            redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "error");
            redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Erro");
            return ConstVariable.redirect + "cart";
        }

        // Cálculo do total e configuração dos itens do pedido
        int totalPrice = 0;
        for (OrderItem cart : listCart.values()) {
            String name = Optional.ofNullable(cart.getProduct())
                    .map(Product::getName)
                    .orElseGet(() -> Optional.ofNullable(cart.getFood())
                            .map(Food::getName)
                            .orElseThrow(() -> new IllegalArgumentException("Expect Product or Food")));

            cart.setName(name);
            cart.setLabel(name);
            cart.setDescription("Nome do produto: " + name + ", Quantidade: " + cart.getQuantity());
            cart.setCurrency(CURRENCY);

            totalPrice += cart.getTotal();
        }

        // Configuração do pedido e pagamento
        String note = Optional.ofNullable(map.get("note")).orElse("Pedido de " + customerSession.getFullName());
        String orderCode = ORDER_PREFIX + ThreadLocalRandom.current().nextInt(516, 59881 + 1);
        Date now = new Date();

        Payment.TransactionType transactionType = "COD".equals(transaction) ? Payment.TransactionType.Cash : Payment.TransactionType.ATM;
        Payment payment = new Payment(transaction, transactionType, now, totalPrice);

        List<OrderItem> listOrderItem = new ArrayList<>(listCart.values());
        Order order = new Order(
                orderCode,
                "order-" + DateUtil.asCompactDateTimeId(now),
                customerSession,
                Arrays.asList(payment),
                listOrderItem,
                note,
                Order.State.DUE,
                now
        );

        // Envio de e-mail
        try {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            String subject = "Pedido realizado com sucesso";
            StringBuilder body = new StringBuilder();
            body.append("<div style='width:800px;text-align:center;margin:auto;padding:10px; border-style: solid; border-color: #8A2BE2;'>")
                    .append("<h2>Cliente:</h2>")
                    .append("<b style='font-size:20px'>").append(customerSession.getFullName()).append("</b>")
                    .append(" realizou um pedido no valor de: <br/>");

            for (OrderItem cart : listCart.values()) {
                String name = cart.getName();
                body.append("<h4>").append(name).append("&ensp;&ensp; ").append(cart.getTotal()).append(" ").append(CURRENCY).append("</h4><br/>");
            }

            body.append("<h2>Total do pedido: ").append(totalPrice).append(" ").append(CURRENCY).append("</h2>")
                    .append("</div>");

            helper.setFrom("Amici-Pelosi");
            helper.setTo(customerSession.getEmail());
            helper.setSubject(subject);
            helper.setText(body.toString(), true);

            sender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Persistência do pedido e limpeza do carrinho
        amiciPelosiService.saveOrder(order);
        session.removeAttribute("listCart");
        cookieService.delete("listCart");
        session.removeAttribute("totalPrice");

        redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "Pedido realizado com sucesso");
        redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "success");
        redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Sucesso");

        return ConstVariable.redirect + "home";
    }



    @GetMapping("/delete/{sortName}")
    public String deleteProduct(@PathVariable("sortName") String sortName, HttpSession session, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        // Obtém o URL de referência da página anterior
        String referer = request.getHeader("Referer");

        // Recupera o carrinho de compras da sessão
        Map<String, OrderItem> listCart = (Map<String, OrderItem>) session.getAttribute("listCart");

        // Remove o item identificado por 'sortName' do carrinho
        listCart.remove(sortName);

        // Atualiza o carrinho na sessão
        session.setAttribute("listCart", listCart);

        // Adiciona mensagens de notificação para informar o sucesso da exclusão
        redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "Exclusão bem-sucedida");
        redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "sucesso");
        redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Sucesso");

        // Redireciona para a página anterior
        return ConstVariable.redirectRefer + referer;
    }


    @PostMapping(path = "/searchProduct"/*, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE*/)
    @ResponseBody
    public List<Product> findProductbyKeyWord(@RequestParam Map<String, String> m) {
        String option = m.get("select");
        String search = m.get("search");
        List<Product> listSearchProduct = null;

        if (option.equalsIgnoreCase("productName")) {
            listSearchProduct = amiciPelosiService.findProductsByName(search);

        }

        return listSearchProduct;
    }

    @PostMapping(path = "/searchFood")
    @ResponseBody
    public List<Food> findFoodbyKeyword(@RequestParam Map<String, String> m, RedirectAttributes redirectAttributes) {
        String search = m.get("search");
        String option = m.get("select");

        List<Food> listSearchFood = null;
        if (option.equalsIgnoreCase("productName")) {
            listSearchFood = amiciPelosiService.findFoodbyName(search);
        }
        return listSearchFood;
    }
}
