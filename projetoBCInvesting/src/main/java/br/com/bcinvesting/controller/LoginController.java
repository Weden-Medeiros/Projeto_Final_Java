package br.com.bcinvesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.bcinvesting.model.Usuario;
import br.com.bcinvesting.repository.UsuariosRepo;

@Controller
public class LoginController{
	
	@Autowired
	private UsuariosRepo repo;
	
	
	@GetMapping("/login")
	public String index(){
		return "login/index";
	}


	@PostMapping("/logar")
	//public String logar(Model model, String email, String senha){
	public String logar(Model model, Usuario usuParam){
		Usuario usu = this.repo.Login(usuParam.getEmail(), usuParam.getSenha());
		if(usu != null) {
			return "redirect:/";
		}
		model.addAttribute("erro", "Usuário ou senha inválidos");
		return "login/index";
	}
	

}
