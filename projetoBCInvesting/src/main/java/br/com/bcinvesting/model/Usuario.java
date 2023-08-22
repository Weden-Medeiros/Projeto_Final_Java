package br.com.bcinvesting.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabela_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int id_usuario;
	
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "cpf", length = 14, nullable = false, unique = true) // Adicionando a anotação "unique"
	private String cpf;
	
	@Column(name = "email", length = 180, nullable = false)
	private String email;
	
	@Column(name = "senha", length = 255, nullable = false)
	private String senha;
	
	@Column(name = "data_cadastro")
	private Date data_cadastro;
	
	@Column(name = "perfil_usuario", length = 3)
	private int perfil_usuario;
	
	//Métodos Getters e Setters 
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
	    return cpf;
	}

	public void setCpf(String cpf) {
	    this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Date getData_cadastro() {
	    return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
	    this.data_cadastro = data_cadastro;
	}

	public int getPerfil_usuario() {
	    return perfil_usuario;
	}

	public void setPerfil_usuario(int perfil_usuario) {
	    this.perfil_usuario = perfil_usuario;
	}
	
	
	
}