package com.mcesar.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcesar.bookstore.domain.Categoria;
import com.mcesar.bookstore.domain.Livro;
import com.mcesar.bookstore.repositories.CategoriaRepository;
import com.mcesar.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instaciaBaseDeDados() {
		Categoria categoria = new Categoria(null, "Informática", "Livros de TI");
		Categoria categoria2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
		Categoria categoria3 = new Categoria(null, "Biografias", "Livros de Biografias");

		Livro livro = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", categoria);
		Livro livro2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", categoria);
		Livro livro3 = new Livro(null, "The Time Machine", "H.G. Welss", "Lorem ipsum", categoria2);
		Livro livro4 = new Livro(null, "The War of the Worlds", "H.G. Welss", "Lorem ipsum", categoria2);
		Livro livro5 = new Livro(null, "I, Robot", "Isaac Asimov", "Lorem ipsum", categoria2);

		categoria.getLivros().addAll(Arrays.asList(livro, livro2));
		categoria2.getLivros().addAll(Arrays.asList(livro3, livro4, livro5));
		
		this.categoriaRepository.saveAll(Arrays.asList(categoria, categoria2, categoria3));
		this.livroRepository.saveAll(Arrays.asList(livro, livro2, livro3, livro4, livro5));
	}

}
