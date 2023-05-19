package com.api.livros.services;

import com.api.livros.entities.Livro;
import com.api.livros.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepo;

    public List<Livro> getAllLivros() {
        return livroRepo.findAll();
    }

    public Livro getLivroById(Integer id) {
        return livroRepo.findById(id).orElse(null);
    }

    public Livro saveLivro(Livro livro) {
        return livroRepo.save(livro);
    }

    public Livro updateLivro(Livro livro) {
        return livroRepo.save(livro);
    }

    public Boolean deleteLivro(Integer id) {
        Livro livroResponse= livroRepo.findById(id).orElse(null);

        //pesquisando para saber que se aluno a ser deletado existe
        if(livroResponse == null) return false;

        livroRepo.deleteById(id);

        livroResponse= livroRepo.findById(id).orElse(null);

        //pesquisando para saber se o aluno deletado realmente foi deletado
        if(livroResponse == null) return true;
        else return false;
    }



}
