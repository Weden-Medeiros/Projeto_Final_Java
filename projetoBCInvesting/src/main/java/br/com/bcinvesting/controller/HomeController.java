package br.com.bcinvesting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.bcinvesting.model.Usuario;
import br.com.bcinvesting.repository.UsuariosRepo;

@Controller
public class HomeController{
	
	private UsuariosRepo repo;
	
	@GetMapping("/")
	public String index(){
		return "home/index";
	}
	
	
//	@PostMapping("/logar")
//	public String logar(Model model, Usuario usuParam, String senha, String lembrar){
//		return "login/index";
//	}
	
	
}
