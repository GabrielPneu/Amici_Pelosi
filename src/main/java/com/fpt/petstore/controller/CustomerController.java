package com.fpt.petstore.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.fpt.petstore.entities.BaseAccount;
import com.fpt.petstore.services.FileUploadUtil;
import com.fpt.petstore.services.RandomString;
import com.fpt.petstore.util.DateUtil;
import com.fpt.petstore.entities.ConstVariable;
import com.fpt.petstore.services.AmiciPelosiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fpt.petstore.entities.Customer;


/**
 * Classe responsável pelo controle das operações relacionadas aos clientes.
 *
 * Esta classe gerencia as requisições HTTP associadas aos clientes, como
 * a criação, atualização, exclusão e listagem de clientes. Ela utiliza
 * o serviço de cliente (CustomerService) para orquestrar a lógica de negócios
 * e garantir que os dados sejam manipulados corretamente. O Controller também
 * lida com a validação de dados e a formatação das respostas para a API.
 *
 * Desenvolvido por Rafael Alves e Gabriel Perereira
 */




@Controller
@SuppressWarnings("unchecked")
public class CustomerController {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private AmiciPelosiService amiciPelosiService;
    @Autowired
    private RandomString randomString;


    // Método para processar o login do cliente
    @PostMapping(value = {"/login"})
    public String login(@RequestParam Map<String, String> m, RedirectAttributes rA, HttpSession session, HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        String email = m.get("email");
        String password = m.get("password");

        // Tentativa de login do cliente
        Customer customer = amiciPelosiService.customerLogin(email, password);

        // Se o cliente for encontrado, armazena as informações na sessão e redireciona
        if (customer != null) {
            session.setAttribute("customer", customer);
            return "redirect:" + referer;
        } else {
            // Caso o login falhe, adiciona uma notificação de erro
            rA.addFlashAttribute(ConstVariable.messageNotification, "E-mail ou senha incorretos");
            rA.addFlashAttribute(ConstVariable.themeNotification, "error");
            rA.addFlashAttribute(ConstVariable.titleNotification, "Erro");
            rA.addFlashAttribute("callModal", "callModal");
            return "redirect:" + referer;
        }
    }

    @GetMapping(value = {"/loggout"})
    public String viewLogout(HttpSession session, HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        session.removeAttribute("customer");
        return ConstVariable.redirectRefer + referer;
    }


    //Método responsável por processar o registro de um novo cliente.
    @PostMapping(value = "/register")
    public String doARegister(@RequestParam Map<String, String> m, RedirectAttributes redirectAttributes, HttpServletRequest request) {

        String referer = request.getHeader("Referer");

        String password = m.get("password");
        String confirm = m.get("confirmPassword");
        String phoneNumber = m.get("phoneNumber");
        String email = m.get("email");
        String gender = m.get("radio");
        String address = m.get("address");
        String fullName = m.get("fullName");


        //Criando novo cliente
        Customer customer = new Customer(fullName).
                withUsername(email).
                withPassword(password).
                withPhone(phoneNumber).
                withAddress(address).
                withAvatar("customer-default.jpg").
                withGender(BaseAccount.Gender.valueOf(gender)).
                withEmail(email);

        Customer customerExistCustomer = amiciPelosiService.findCustomerbyEmail(email);
        if (customerExistCustomer != null) {
            redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "E-mail já cadastrado. Por favor, insira um e-mail diferente.");
            redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "error");
            redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Erro");
            redirectAttributes.addFlashAttribute("callModalRegister", "callModalRegister");
            return ConstVariable.redirectRefer + referer;
        }
        if (email.equals("") || password.equals("") || confirm.equals("") || phoneNumber.equals("") || gender.equals("") || address.equals("") || fullName.equals("")) {
            redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "Não pode deixar campos vazios");
            redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "error");
            redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Erro");
            redirectAttributes.addFlashAttribute("callModalRegister", "callModalRegister");
            return ConstVariable.redirectRefer + referer;
        }
        if (confirm.equals(password)) {
            amiciPelosiService.saveCustomer(customer);
            redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "Conta criada com sucesso");
            redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "success");
            redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Sucesso");
            return ConstVariable.redirectRefer + referer;
        } else {
            redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "Erro: as senhas não coincidem");
            redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "error");
            redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Erro");
            redirectAttributes.addFlashAttribute("callModalRegister", "callModalRegister");
            return ConstVariable.redirectRefer + referer;
        }
    }


    //Método responsável por atualizar informações do cliente.
    @PostMapping("/updateInfor")
    public String updateInfor(HttpServletRequest request, @RequestParam Map<String, String> m, @RequestParam("avatarUrl") MultipartFile multipartFile, HttpSession session, RedirectAttributes redirectAttributes) throws IOException {
        String referer = request.getHeader("Referer");
        Customer sessionCustomer = (Customer) session.getAttribute("customer");
        String fullName = m.get("fullName");
        String phone = m.get("phoneNumber");
        String avatarUrl = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String address = m.get("address");
        String birthday = m.get("birthday");
        Date birthdayFormat = DateUtil.parseDate(birthday);
        if (avatarUrl.equals("")) {
            amiciPelosiService.updateCustomer(sessionCustomer.getId(), fullName, phone, address, sessionCustomer.getAvatarUrl(), birthdayFormat);
        } else {
            amiciPelosiService.updateCustomer(sessionCustomer.getId(), fullName, phone, address, avatarUrl, birthdayFormat);
            String uploadDir = "user-photos/" + sessionCustomer.getId();
            FileUploadUtil.saveFile(uploadDir, avatarUrl, multipartFile);
        }
        redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "Atualização de conta realizada com sucesso");
        redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "success");
        redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Sucesso");


        return ConstVariable.redirectRefer + referer;
    }


    //Método responsável por atualizar a senha.
    @PostMapping("/updatePassword")
    public String updatePassword(@RequestParam Map<String, String> m, HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttributes) {
        String referer = request.getHeader("Referer");
        Customer sessionCustomer = (Customer) session.getAttribute("customer");
        String oldPassword = m.get("oldPassword");
        String newPassword = m.get("newPassword");
        String confirmPassword = m.get("confirmPassword");
        Customer passwordExist = amiciPelosiService.findCustomerByPassword(sessionCustomer.getId(), oldPassword);

        if (passwordExist != null) {
            if (newPassword.equals(confirmPassword)) {
                amiciPelosiService.updatePassword(sessionCustomer.getId(), newPassword);
                redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "Atualização de senha realizada com sucesso");
                redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "success");
                redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Sucesso");
            } else {
                redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "A nova senha não coincide com a senha de confirmação");
                redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "error");
                redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Erro");
                redirectAttributes.addFlashAttribute("callModalChange", "callModalChange");
            }
        } else {
            redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "Senha antiga incorreta");
            redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "error");
            redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Erro");
            redirectAttributes.addFlashAttribute("callModalChange", "callModalChange");
        }

        return ConstVariable.redirectRefer + referer;
    }

    //Metodo responsável por gerenciar a visualização da página de recuperação de sennah
    @GetMapping("/esqueci-minha-senha/{token}")
    public String viewForgetPassword(@PathVariable("token") String token, ModelMap modelMap, RedirectAttributes redirectAttributes) {
        Customer tokenExist = amiciPelosiService.findCustomerByToken(token);
        if (tokenExist != null) {
            modelMap.addAttribute("token", token);
            return "forgetPassword";
        } else {
            redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "Token não encontrado");
            redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "error");
            redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Erro");
            return ConstVariable.redirect + "home";
        }
    }

    // Envia um e-mail de recuperação de senha com um token para o usuário, permitindo a alteração da senha.
    @PostMapping("/envia-email-mudasenha")
    @Transactional
    public String sendMailChange(@RequestParam Map<String, String> m, RedirectAttributes redirectAttributes, HttpSession session) {
        String email = m.get("email");
        String token = randomString.getRandomString(20);
        Date tokenCreatedDate = new Date();
        Customer findCustomerByEmail = amiciPelosiService.findCustomerbyEmail(email);
        if (findCustomerByEmail != null) {
            try {
                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message);
                String from = "amici-pelosi";
                String subject = "Redefinição de senha Amici Pelosi";
                String url = "http://localhost:8081/forgot-password/" + token;
                String body = "<div style='width:500px;text-align:center; border-style: solid; border-color: #8A2BE2;'>" +
                        "<h2>O usuário:</h2>" +
                        "<b style='font-size:20px'>" + findCustomerByEmail.getFullName() + "</b>" + " solicitou uma mudança de senha" +
                        "<p style='font-style: italic;'>Este e-mail é valido por 15 minutos</p>" +
                        "<h3>Mude sua senha aqui</h3>" +
                        "<a style='font-size:20px' href='" + url + "'>" + "amicipelosi.com/" + token + "</a>" +
                        "</div>";
                helper.setFrom(from, from);
                helper.setTo(email);
                helper.setReplyTo(from, from);
                helper.setSubject(subject);
                helper.setText(body, true);
                mailSender.send(message);
                amiciPelosiService.updateCustomerToken(email, token, tokenCreatedDate);
                redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "O e-mail para redefinir a senha foi enviado para o seu e-mail");
                redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "success");
                redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Sucesso");

            } catch (Exception e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "Erro");
                redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "error");
                redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Erro");
            }
        } else {
            redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "E-mail não encontrado");
            redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "error");
            redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Falha");
        }

        return ConstVariable.redirect + "home";
    }



    //verifica o token de redefinição de senha, valida se a senha de confirmação corresponde à nova senha e se o token não expirou, atualizando a senha do usuário.
    @PostMapping("/changePassword")
    @Transactional
    public String formChangePassword(@RequestParam Map<String, String> m, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String referer = request.getHeader("referer");
        String currentToken = m.get("token");
        Date currentDate = new Date();
        Customer findCustomerByToken = amiciPelosiService.findCustomerByToken(currentToken);
        String newPassword = m.get("newPassword");
        String confirmPassword = m.get("confirmPassword");
        long timePassed = (currentDate.getTime() - findCustomerByToken.getCreatedTimeToken().getTime()) / 1000;

        if (timePassed <= 30) {
            if (confirmPassword.equals(newPassword)) {
                amiciPelosiService.updatePasswordByToken(currentToken, newPassword, null, null);
                redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "Alteração de senha bem-sucedida");
                redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "success");
                redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Sucesso");
                return ConstVariable.redirect + "home";
            } else {
                redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "A senha de confirmação não coincide com a nova senha");
                redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "error");
                redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Falha");
                return ConstVariable.redirectRefer + referer;
            }
        } else {
            redirectAttributes.addFlashAttribute(ConstVariable.messageNotification, "Tempo expirado");
            redirectAttributes.addFlashAttribute(ConstVariable.themeNotification, "error");
            redirectAttributes.addFlashAttribute(ConstVariable.titleNotification, "Erro");
            return ConstVariable.redirect + "home";
        }




}
}
