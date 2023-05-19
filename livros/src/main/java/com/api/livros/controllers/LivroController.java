package com.api.livros.controllers;

import com.api.livros.entities.Livro;
import com.api.livros.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> getAllLivros() {
        return new ResponseEntity<>(livroService.getAllLivros(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getLivroById(@PathVariable Integer id) {
        Livro livroResponse = livroService.getLivroById(id);

        if(livroResponse == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(livroResponse, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Livro> saveLivro(@RequestBody Livro livro) {
        Livro livroResponse = livroService.saveLivro(livro);

        if(livroResponse == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity<>(livroResponse, HttpStatus.CREATED);
        }
    }

    @PutMapping
    public ResponseEntity<Livro> updateLivro(@RequestBody Livro livro) {
        Livro livroResponse = livroService.updateLivro(livro);

        if(livroResponse == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity<>(livroResponse, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteLivro(@PathVariable Integer id) {
        Boolean livroResponse = livroService.deleteLivro(id);

        if(livroResponse) {
            return new ResponseEntity<>(livroResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
}
