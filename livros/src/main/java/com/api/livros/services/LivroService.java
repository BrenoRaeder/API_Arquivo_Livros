package com.api.livros.services;

import com.api.livros.DTOs.LivroDTO;
import com.api.livros.entities.Livro;
import com.api.livros.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepo;

    public List<Livro> getAllLivros() {
        return livroRepo.findAll();
    }

    public List<LivroDTO> getAllLivrosDTO() {
        List<Livro> listaLivro = livroRepo.findAll();

        List<LivroDTO> listaLivroDTO = new ArrayList<>();

        for(Livro l : listaLivro) {
            LivroDTO livroDTO = new LivroDTO(l);
            listaLivroDTO.add(livroDTO);
        }

        return listaLivroDTO;
    }

    public Livro getLivroById(Integer id) {
        return livroRepo.findById(id).orElse(null);
    }

    public LivroDTO getLivroDTOById(Integer id) {
        Livro livro = livroRepo.findById(id).orElse(null);

        if(livro == null) return null;

        return new LivroDTO(livro);
    }

    public Livro saveLivro(Livro livro) {
        return livroRepo.save(livro);
    }

    public Livro updateLivro(Livro livro) {
        return livroRepo.save(livro);
    }

    public Boolean deleteLivro(Livro livro) {
        Livro livroResponse= livroRepo.findById(livro.getIdLivro()).orElse(null);

        //pesquisando para saber que se aluno a ser deletado existe
        if(livroResponse == null) return false;

        livroRepo.delete(livro);

        livroResponse= livroRepo.findById(livro.getIdLivro()).orElse(null);

        //pesquisando para saber se o aluno deletado realmente foi deletado
        if(livroResponse == null) return true;
        else return false;
    }
}
