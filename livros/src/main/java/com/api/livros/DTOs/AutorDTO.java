package com.api.livros.DTOs;

import com.api.livros.entities.Autor;
import com.api.livros.entities.Livro;

import java.util.ArrayList;
import java.util.List;

public class AutorDTO {

    private int idAutor;
    private String nome;
    private List<LivroResumidoDTO> listaLivros;

    public AutorDTO() {

    }

    public AutorDTO(Autor autor) {
        this.idAutor = autor.getIdAutor();
        this.nome = autor.getNome();

        List<LivroResumidoDTO> listaLivroResumido = new ArrayList<>();

        for(Livro l : autor.getListaLivros()) {
            LivroResumidoDTO livroResumido = new LivroResumidoDTO(l);
            listaLivroResumido.add(livroResumido);
        }

        this.listaLivros = listaLivroResumido;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<LivroResumidoDTO> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(List<LivroResumidoDTO> listaLivros) {
        this.listaLivros = listaLivros;
    }
}
