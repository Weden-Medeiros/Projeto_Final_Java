package br.com.bcinvesting.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	@PostMapping("/usuarios/{id}")
	public String busca(@PathVariable int id, Model model){
		Optional<Usuario> usu = repo.findById(id);
		model.addAttribute("usuario", usu);
		return "/usuarios/editar";
	}
	
//	@GetMapping("/usuarios/{id}/busca")
//    public String buscaUsuarioPorId(@PathVariable int id, Model model) {
//        Optional<Usuario> usuario = repo.findById(id);
//        if (usuario.isPresent()) {
//            model.addAttribute("usuario", usuario.get());
//            return "usuarios/editar"; // Retorne o nome do template apropriado
//        } else {
//            return "error"; // Ou retorne uma página de erro personalizada
//        }
//    }
	
	@GetMapping("/usuarios/{id}/excluir") //usando get pois esta usando parametro
	public String excluir(@PathVariable int id){
		repo.deleteById(id);
		return "redirect:/usuarios";
	}
	
	
	
	@GetMapping("/usuarios/{id}/editar")
    public String editar(@PathVariable int id, Model model) {
        Optional<Usuario> usuarioOpt = repo.findById(id);
        
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            model.addAttribute("usuario", usuario);
            return "usuarios/editar";
        } else {
            // Handle case where user with given ID is not found
            return "error";
        }
    }

    @PostMapping("/usuarios/{id}/atualizar")
    public String atualizar(@PathVariable int id, Usuario usuario) {
        usuario.setId_usuario(id); // Ensure ID is set for updating
        repo.save(usuario);
        return "redirect:/usuarios";
    }
	
//	@PostMapping("/usuarios/{id}/atualizar")
//	public String atualizar(@PathVariable int id, @Valid Usuario usuario, BindingResult result) {
//	    if (result.hasErrors()) {
//	        // Se houver erros de validação, retorne para a página de edição com mensagens de erro
//	        return "pagina_de_edicao";
//	    }
//	    
//	    usuario.setId_usuario(id); // Certifique-se de que o ID seja definido para atualização
//	    try {
//	        repo.save(usuario);
//	    } catch (Exception e) {
//	        // Lidar com exceções de salvamento (por exemplo, ConstraintViolationException) aqui
//	        // Pode redirecionar para uma página de erro ou retornar mensagens de erro
//	    }
//	    
//	    return "redirect:/usuarios"; // Redirecionamento após a atualização bem-sucedida
//	}
	
}
