package com.mcesar.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcesar.bookstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
