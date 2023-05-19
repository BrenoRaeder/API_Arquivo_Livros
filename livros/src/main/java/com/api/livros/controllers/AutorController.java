package com.api.livros.controllers;

import com.api.livros.entities.Autor;
import com.api.livros.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    AutorService livroService;

    @GetMapping
    public ResponseEntity<List<Autor>> getAllAutors() {
        return new ResponseEntity<>(livroService.getAllAutores(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable Integer id) {
        Autor livroResponse = livroService.getAutorById(id);

        if(livroResponse == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(livroResponse, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Autor> saveAutor(@RequestBody Autor autor) {
        Autor livroResponse = livroService.saveAutor(autor);

        if(livroResponse == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity<>(livroResponse, HttpStatus.CREATED);
        }
    }

    @PutMapping
    public ResponseEntity<Autor> updateAutor(@RequestBody Autor autor) {
        Autor livroResponse = livroService.updateAutor(autor);

        if(livroResponse == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity<>(livroResponse, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAutor(@PathVariable Integer id) {
        Boolean livroResponse = livroService.deleteAutor(id);

        if(livroResponse) {
            return new ResponseEntity<>(livroResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
}
