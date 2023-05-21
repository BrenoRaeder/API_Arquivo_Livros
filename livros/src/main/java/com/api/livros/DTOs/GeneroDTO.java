package com.api.livros.DTOs;

import com.api.livros.entities.Genero;
import com.api.livros.entities.Livro;

import java.util.ArrayList;
import java.util.List;

public class GeneroDTO {

    private Integer idGenero;
    private String nome;
    private List<LivroResumidoDTO> listaLivro;

    public GeneroDTO() {}


    public GeneroDTO(Genero genero) {
        this.idGenero = genero.getIdGenero();
        this.nome = genero.getNome();

        List<LivroResumidoDTO> listaLivro = new ArrayList<>();

        for(Livro l : genero.getListaLivros()) {
            LivroResumidoDTO livro = new LivroResumidoDTO(l);
            listaLivro.add(livro);
        }

        this.listaLivro = listaLivro;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<LivroResumidoDTO> getListaLivro() {
        return listaLivro;
    }

    public void setListaLivro(List<LivroResumidoDTO> listaLivro) {
        this.listaLivro = listaLivro;
    }
}
