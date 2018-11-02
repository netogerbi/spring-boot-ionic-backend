package com.netogerbi.cursomc.dto;

import java.io.Serializable;

public class CredenciaisDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String senha;
	
	
	public CredenciaisDTO() {
	}
	
	public CredenciaisDTO(String usuario, String senha) {
		this.email = usuario;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setUsuario(String usuario) {
		this.email = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
