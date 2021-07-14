package com.mcesar.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcesar.bookstore.domain.Livro;
import com.mcesar.bookstore.exceptions.ObjectNotFoundException;
import com.mcesar.bookstore.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;

	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Long id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " + id + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Long id_cat) {
		categoriaService.findById(id_cat);
		return repository.findAllByCategoria(id_cat);
	}
	
	public Livro create(Long cat_id, Livro obj) {
		obj.setId(null);
		obj.setCategoria(categoriaService.findById(cat_id));
		return repository.save(obj);
	}

	public Livro update(Long id, Long cat_id, Livro obj) {
		Livro newObj = this.findById(id);
		newObj.setTitulo(obj.getTitulo());
		newObj.setAutor(obj.getAutor());
		newObj.setTexto(obj.getTexto());
		newObj.setCategoria(categoriaService.findById(cat_id));
		return repository.save(newObj);
	}

	public void delete(Long id) {
		this.findById(id);
		repository.deleteById(id);
	}
}
