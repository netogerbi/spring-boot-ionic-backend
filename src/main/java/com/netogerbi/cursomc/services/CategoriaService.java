package com.netogerbi.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netogerbi.cursomc.domain.Categoria;
import com.netogerbi.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
