package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController implements ErrorController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/error")
	public String handleError(Model model, HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
		String mensagem = String.format(
				"<html><body>" + "<div>Exceção lançada: <b>%s</b></div><body></html>", statusCode,
				exception == null ? "N/A" : exception.getMessage());
		model.addAttribute("messagem", mensagem);
		return "ops";
	}

	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}

	

}
