package br.com.bcinvesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import br.com.bcinvesting.model.Usuario;
import br.com.bcinvesting.repository.UsuariosRepo;


@Controller
public class UsuariosController{
	
	@Autowired
	private UsuariosRepo repo;
	
	@GetMapping("/usuarios") //rota
	public String index(Model model){
		List<Usuario> usuarios = (List<Usuario>)repo.findAll();
		model.addAttribute("usuarios", usuarios);
		return "usuarios/index";
	}
	
	@GetMapping("/usuarios/cadastro")
	public String registro(){
		return "usuarios/registro";
	}
	
	@PostMapping("/usuarios/criar")
	public String criar(Usuario usuario){
		repo.save(usuario);
		return "redirect:/";
	}
	
	@GetMapping("/usuarios/{id}/excluir") //usando get pois esta usando parametro
	public String excluir(@PathVariable int id){
		repo.deleteById(id);
		return "redirect:/usuarios";
	}
	
	
	
}
