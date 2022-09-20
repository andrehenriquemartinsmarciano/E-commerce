package com.ecommerce.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "SocioAssistente")
public class SocioAssistente implements Serializable{
	 private static final long serialVersionUID = -2420346134960559062L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_socio_assistente;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(unique = true)
	private String cpf;
	@Column(nullable = false, length = 18)
	private int telefone;
	@Column(nullable = false, length = 100)
	private String endereco;
	public int getId_socio_assistente() {
		return id_socio_assistente;
	}
	public void setId_socio_assistente(int id_socio_assistente) {
		this.id_socio_assistente = id_socio_assistente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	

}
