package com.api.livros.controllers;

import com.api.livros.DTOs.AutorDTO;
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
    AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Autor>> getAllAutores() {
        return new ResponseEntity<>(autorService.getAllAutores(), HttpStatus.OK);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<AutorDTO>> getAllAutoresDTO() {
        return new ResponseEntity<>(autorService.getAllAutoresDTO(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable Integer id) {
        Autor autorResponse = autorService.getAutorById(id);

        if(autorResponse == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(autorResponse, HttpStatus.OK);
        }
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<AutorDTO> getAutorDTOById(@PathVariable Integer id) {
        AutorDTO autorResponse = autorService.getAutorDTOById(id);

        if(autorResponse == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(autorResponse, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Autor> saveAutor(@RequestBody Autor autor) {
        Autor autorResponse = autorService.saveAutor(autor);

        if(autorResponse == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity<>(autorResponse, HttpStatus.CREATED);
        }
    }

    @PutMapping
    public ResponseEntity<Autor> updateAutor(@RequestBody Autor autor) {
        Autor autorResponse = autorService.updateAutor(autor);

        if(autorResponse == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity<>(autorResponse, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAutor(@PathVariable Integer id) {
        Boolean autorResponse = autorService.deleteAutor(id);

        if(autorResponse) {
            return new ResponseEntity<>(autorResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
}
