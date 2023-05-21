package com.api.livros.services;

import com.api.livros.DTOs.AutorDTO;
import com.api.livros.entities.Autor;
import com.api.livros.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepo;

    public List<Autor> getAllAutores() {
        return autorRepo.findAll();
    }

    public List<AutorDTO> getAllAutoresDTO() {

        List<Autor> listaAutores = autorRepo.findAll();

        List<AutorDTO> listaAutoresDTO = new ArrayList<>();

        for(Autor a : listaAutores ) {
            AutorDTO autorDTO = new AutorDTO(a);
            listaAutoresDTO.add(autorDTO);
        }

        return listaAutoresDTO;
    }

    public Autor getAutorById(Integer id) {
        return autorRepo.findById(id).orElse(null);
    }

    public AutorDTO getAutorDTOById(Integer id) {

        Autor autor = autorRepo.findById(id).orElse(null);
        if(autor == null)
            return null;

        return new AutorDTO(autor);
    }

    public Autor saveAutor(Autor autor) {
        return autorRepo.save(autor);
    }

    public Autor updateAutor(Autor autor) {
        return autorRepo.save(autor);
    }

    public Boolean deleteAutor(Integer id) {
        Autor autorResponse= autorRepo.findById(id).orElse(null);

        //pesquisando para saber que se aluno a ser deletado existe
        if(autorResponse == null) return false;

        autorRepo.deleteById(id);

        autorResponse= autorRepo.findById(id).orElse(null);

        //pesquisando para saber se o aluno deletado realmente foi deletado
        if(autorResponse == null) return true;
        else return false;
    }
}
