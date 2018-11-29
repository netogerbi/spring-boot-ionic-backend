package com.netogerbi.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.netogerbi.cursomc.domain.Estado;

public class EstadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String nome;

	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=2, max=30, message="O tamanho deve ser entre 2 e 30 caracteres!")
	public EstadoDTO() {
		super();
	}

	public EstadoDTO(Estado obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
