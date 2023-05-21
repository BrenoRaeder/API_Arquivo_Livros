package com.api.livros.services;

import com.api.livros.DTOs.GeneroDTO;
import com.api.livros.entities.Genero;
import com.api.livros.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeneroService {

    @Autowired
    GeneroRepository generoRepo;

    public List<Genero> getAllGeneros() {
        return generoRepo.findAll();
    }

    public List<GeneroDTO> getAllGenerosDTO() {

        List<Genero> listaGeneros = generoRepo.findAll();

        List<GeneroDTO> listaGenerosDTO = new ArrayList<>();

        for(Genero a : listaGeneros ) {
            GeneroDTO generoDTO = new GeneroDTO(a);
            listaGenerosDTO.add(generoDTO);
        }

        return listaGenerosDTO;
    }

    public Genero getGeneroById(Integer id) {
        return generoRepo.findById(id).orElse(null);
    }

    public GeneroDTO getGeneroDTOById(Integer id) {

        Genero genero = generoRepo.findById(id).orElse(null);
        if(genero == null)
            return null;

        return new GeneroDTO(genero);
    }

    public Genero saveGenero(Genero genero) {
        return generoRepo.save(genero);
    }

    public Genero updateGenero(Genero genero) {
        return generoRepo.save(genero);
    }

    public Boolean deleteGenero(Integer id) {
        Genero generoResponse= generoRepo.findById(id).orElse(null);

        //pesquisando para saber que se aluno a ser deletado existe
        if(generoResponse == null) return false;

        generoRepo.deleteById(id);

        generoResponse= generoRepo.findById(id).orElse(null);

        //pesquisando para saber se o aluno deletado realmente foi deletado
        if(generoResponse == null) return true;
        else return false;
    }
}
