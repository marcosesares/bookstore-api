package com.mcesar.bookstore.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livro implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Campo TITULO é requerido")
	@Length(min = 3, max = 50, message = "O campo TITULO deve ter entre 3 e 50 caracteres")
	private String titulo;

	@NotEmpty(message = "Campo AUTOR é requerido")
	@Length(min = 3, max = 50, message = "O campo AUTOR deve ter entre 3 e 50 caracteres")
	private String autor;

	@NotEmpty(message = "Campo TEXTO é requerido")
	@Length(min = 10, message = "O campo TEXTO deve ter no mínimo 10 caracteres")
	private String texto;

	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Categoria categoria;

	public Livro() {
		super();
	}
	
	public Livro(Long id, String titulo, String autor, String texto, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.texto = texto;
		this.categoria = categoria;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}
}
