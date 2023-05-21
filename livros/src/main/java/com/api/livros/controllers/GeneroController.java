package com.api.livros.controllers;

import com.api.livros.DTOs.GeneroDTO;
import com.api.livros.entities.Genero;
import com.api.livros.services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/generos")
public class GeneroController {
    @Autowired
    GeneroService generoService;

    @GetMapping
    public ResponseEntity<List<Genero>> getAllGeneros() {
        return new ResponseEntity<>(generoService.getAllGeneros(), HttpStatus.OK);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<GeneroDTO>> getAllGenerosDTO() {
        return new ResponseEntity<>(generoService.getAllGenerosDTO(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> getGeneroById(@PathVariable Integer id) {
        Genero generoResponse = generoService.getGeneroById(id);

        if(generoResponse == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(generoResponse, HttpStatus.OK);
        }
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<GeneroDTO> getGeneroDTOById(@PathVariable Integer id) {
        GeneroDTO generoResponse = generoService.getGeneroDTOById(id);

        if(generoResponse == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(generoResponse, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Genero> saveGenero(@RequestBody Genero genero) {
        Genero generoResponse = generoService.saveGenero(genero);

        if(generoResponse == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity<>(generoResponse, HttpStatus.CREATED);
        }
    }

    @PutMapping
    public ResponseEntity<Genero> updateGenero(@RequestBody Genero genero) {
        Genero generoResponse = generoService.updateGenero(genero);

        if(generoResponse == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity<>(generoResponse, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteGenero(@PathVariable Integer id) {
        Boolean generoResponse = generoService.deleteGenero(id);

        if(generoResponse) {
            return new ResponseEntity<>(generoResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
}
