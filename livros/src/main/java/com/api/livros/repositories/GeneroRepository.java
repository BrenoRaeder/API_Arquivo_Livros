package com.api.livros.repositories;

import com.api.livros.entities.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Integer> {

}
