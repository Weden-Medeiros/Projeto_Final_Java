package br.com.bcinvesting.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.bcinvesting.model.Usuario;

public interface UsuariosRepo extends CrudRepository<Usuario, Integer>{
	
}