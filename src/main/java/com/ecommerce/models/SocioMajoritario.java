package com.ecommerce.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SocioMajoritario")
public class SocioMajoritario implements Serializable {
	private static final long serialVersionUID = -2420346134960559062L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_socio_majoritario")
	private Long id_socio_majoritario;
	@Column(name = "IDADE", nullable = false, unique = false)
	private int idade;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(unique = true)
	private String cpf;
	@Column(nullable = false, length = 18)
	private int telefone;
	@Column(nullable = false, length = 100)
	private String endereco;
	@Column(name = "LOGIN", length = 30, nullable = false, unique = true)
	private String login;
	@Column(name = "SENHA", length = 6, nullable = false, unique = false)
	private String senha;
	@Column(name = "DATA_CADASTRO", nullable = false, unique = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dtCadastro;

	
	
	public Long getId_socio_majoritario() {
		return id_socio_majoritario;
	}

	public void setId_socio_majoritario(Long id_socio_majoritario) {
		this.id_socio_majoritario = id_socio_majoritario;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		SocioMajoritario socioMajoritario  = (SocioMajoritario) o;

		if (id_socio_majoritario != null ? !id_socio_majoritario.equals(socioMajoritario.id_socio_majoritario) : socioMajoritario.id_socio_majoritario != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return id_socio_majoritario != null ? id_socio_majoritario.hashCode() : 0;
	}
}
