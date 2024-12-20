package com.fpt.petstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * Classe responsável pelo controle das mensagens de erro.
 * Desenvolvido por Gabriel Perereira
 */


@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

	@GetMapping(value={"/error"})
	public String error(HttpServletRequest request){
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(status != null){
			Integer statusCode = Integer.valueOf(status.toString());
			if(statusCode == HttpStatus.NOT_FOUND.value()){
				return "error/404error";
			}else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()){
				return "error/500error";
			}else if(statusCode == HttpStatus.FORBIDDEN.value()){
				return "error/403error";
			}
		}
		return "redirect:/";
	}
	@Override
	public String getErrorPath() {
		return "/error/404error";
	}

}
