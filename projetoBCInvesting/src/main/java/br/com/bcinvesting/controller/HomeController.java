package br.com.bcinvesting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController{
	
	private AdministradoresRepo repo;
	
	@GetMapping("/")
	public String index(){
		return "home/index";
	}
	
	
	@PostMapping("/logar")
	public String logar(Model model, Administrador admParam, String senha, String lembrar){
		return "login/index";
	}
	
	
}
