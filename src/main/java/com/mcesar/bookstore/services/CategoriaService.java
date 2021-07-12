package com.mcesar.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcesar.bookstore.domain.Categoria;
import com.mcesar.bookstore.exceptions.ObjectNotFoundException;
import com.mcesar.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Long id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
}
