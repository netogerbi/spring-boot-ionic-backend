package com.netogerbi.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netogerbi.cursomc.domain.Cidade;
import com.netogerbi.cursomc.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;
	
	public List<Cidade> findByEstado(Integer estadoId){
		return repository.findCidades(estadoId);
	}
	
}
