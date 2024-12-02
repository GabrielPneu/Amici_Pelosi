package com.fpt.petstore.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpt.petstore.entities.Contact;
import com.fpt.petstore.entities.Customer;
import com.fpt.petstore.entities.Order;
import com.fpt.petstore.entities.OrderItem;
import com.fpt.petstore.services.CookieService;
import com.fpt.petstore.services.AmiciPelosiService;
import com.fpt.petstore.util.StringUtil;
import com.fpt.petstore.entities.ConstVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * A classse MainController gerencia as requisições HTTP
 * para páginas do site, como a home, sobre, blog, carrinho de compras, checkout,
 * entre outras. Ele também lida com a lógica de cookies e sessões do usuário,
 * além de garantir que funcionalidades restritas sejam acessadas apenas por usuários logados.
 *
 */



@Controller
public class MainController {

    @Autowired
    private AmiciPelosiService amiciPelosiService;

    @Autowired
    private CookieService cookieService;

    private void getCookie(HttpSession session) {
        String listCartAsJson = cookieService.getValue("listCart", "");

        if (!StringUtil.isEmpty(listCartAsJson) && session.getAttribute("listCart") == null) {
            Map<String, OrderItem> listCart = null;
            try {
                listCartAsJson = URLDecoder.decode(listCartAsJson, StandardCharsets.UTF_8.toString());
                listCart = new ObjectMapper().readValue(listCartAsJson, new TypeReference<Map<String, OrderItem>>() {
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            session.setAttribute("listCart", listCart);
        }
    }

    @GetMapping(value = {"/"})
    public String viewHome() {
        return ConstVariable.redirect + "home";
    }

    @GetMapping("/home")
    public String viewHomePage(HttpSession session) {
        getCookie(session);
        return "index";
    }

    @GetMapping("/about")
    public String viewAboutPage(HttpSession session) {
        getCookie(session);
        return "about";
    }

    @GetMapping("/blog")
    public String viewBlogPage(HttpSession session) {
        getCookie(session);
        return "blog";
    }

    @GetMapping("/information")
    public String viewInfoPage(ModelMap modelMap, HttpSession session, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
            Customer customerDetails = amiciPelosiService.getCustomerByUsername(customer.getUsername());
            modelMap.addAttribute("customerDetails", customerDetails);
            return "information";
        } else {
            redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "This functionality is for logged-in users only");
            redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "warning");
            redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Warning");
            return ConstVariable.redirect + "home";
        }
    }

    @GetMapping("/blog-details")
    public String viewBlogDetailsPage(HttpSession session) {
        getCookie(session);
        return "blog-details";
    }

    @GetMapping("/checkout")
    public String viewCheckoutPage(HttpServletRequest request, HttpSession session, ModelMap modelMap, RedirectAttributes redirectAttributes) {
        Customer customer = (Customer) session.getAttribute("customer");
        String referer = request.getHeader("Referer");
        if (customer != null) {
            getCookie(session);
            Map<String, OrderItem> listCart = (Map<String, OrderItem>) session.getAttribute("listCart");
            int totalPrice = 0;
            for (OrderItem orderItem : listCart.values()) {
                totalPrice += orderItem.getTotal();
            }
            modelMap.addAttribute("totalPrice", totalPrice);
            return "checkout";
        } else {
            redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "This functionality is for logged-in users only");
            redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "warning");
            redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Warning");
            return ConstVariable.redirectRefer + referer;
        }
    }

    @GetMapping("/cart")
    public String viewCartPage(HttpSession session, ModelMap modelMap) {
        getCookie(session);

        int totalPrice = 0;
        Map<String, OrderItem> listCart = (Map<String, OrderItem>) session.getAttribute("listCart");
        if (listCart != null) {
            for (OrderItem cart : listCart.values()) {
                totalPrice += cart.getTotal();
            }
        }
        modelMap.addAttribute("totalPrice", totalPrice);

        return "cart";
    }

    @GetMapping("/contact")
    public String viewContactPage(HttpSession session) {
        getCookie(session);
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContact(@RequestParam Map<String, String> m, RedirectAttributes redirectAttributes) {
        String name = m.get("name");
        String email = m.get("email");
        String message = m.get("message");
        Contact contact = new Contact(name, email, message, new Date());
        amiciPelosiService.saveContact(contact);
        redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "Your feedback has been saved");
        redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "success");
        redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Success");
        return ConstVariable.redirect + "contact";
    }

    @GetMapping("/history")
    public String viewTransactionHistory(ModelMap modelMap, HttpSession session, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
            Long customerId = customer.getId();
            List<Order> orderHistory = amiciPelosiService.listOrderbyId(customerId);
            modelMap.addAttribute("orderHistory", orderHistory);
            return "history";
        } else {
            redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "This functionality is for logged-in users only");
            redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "warning");
            redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Warning");
            return ConstVariable.redirect + "home";
        }
    }

    @GetMapping("/order-detail/{id}")
    public String viewOrderDetail(@PathVariable("id") long id, ModelMap modelMap, HttpSession session, RedirectAttributes redirectAttributes) {
        Customer customerSession = (Customer) session.getAttribute("customer");
        if (customerSession != null) {
            List<OrderItem> orderItemList = amiciPelosiService.listOrderItembyOrderId(id);
            int totalPrice = 0;
            for (OrderItem orderItem : orderItemList) {
                totalPrice += orderItem.getTotal();
            }
            modelMap.addAttribute("totalPrice", totalPrice);
            modelMap.addAttribute("orderItemList", orderItemList);
            return "historydetail";
        } else {
            redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "This functionality is for logged-in users only");
            redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "warning");
            redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Warning");
            return ConstVariable.redirect + "home";
        }
    }
}
