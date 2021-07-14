package com.mcesar.bookstore.dtos;

import java.io.Serializable;
import java.util.Objects;

import com.mcesar.bookstore.domain.Livro;

public class LivroDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String titulo;

	public LivroDTO() {
		super();
	}
	
	public LivroDTO(Livro obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LivroDTO other = (LivroDTO) obj;
		return Objects.equals(id, other.id);
	}
}
