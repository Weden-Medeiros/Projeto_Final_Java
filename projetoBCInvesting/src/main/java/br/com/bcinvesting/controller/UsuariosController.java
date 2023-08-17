package br.com.bcinvesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.bcinvesting.model.Usuario;
import br.com.bcinvesting.repository.UsuariosRepo;


@Controller
public class UsuariosController{
	
	@Autowired
	private UsuariosRepo repo;
	
	@GetMapping("/usuarios")
	public String index(Model model){
		List<Usuario> usuarios = (List<Usuario>)repo.findAll();
		model.addAttribute("usuarios", usuarios);
		return "usuarios/index";
	}
	
	
	
}
