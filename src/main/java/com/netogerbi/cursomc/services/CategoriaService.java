package com.netogerbi.cursomc.services;

import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netogerbi.cursomc.domain.Categoria;
import com.netogerbi.cursomc.repositories.CategoriaRepository;
import com.netogerbi.cursomc.services.exceptions.DataIntegrityException;
import com.netogerbi.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: "+id+", Tipo:" + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		}catch(ConstraintViolationException e){
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos!");
		}
		
	}
}
