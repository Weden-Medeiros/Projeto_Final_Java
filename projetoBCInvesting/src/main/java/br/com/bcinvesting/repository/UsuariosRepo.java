package br.com.bcinvesting.repository;

import br.com.bcinvesting.model.Usuario;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UsuariosRepo extends CrudRepository<Usuario, Integer>{
	
	@Query(value="select * from tabela_usuarios where email = :email and senha = :senha", nativeQuery = true)
	public Usuario Login(String email, String senha);
	
}