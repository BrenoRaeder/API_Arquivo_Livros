package com.api.livros.repositories;

import com.api.livros.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
