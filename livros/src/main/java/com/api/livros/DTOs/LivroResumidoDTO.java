package com.api.livros.DTOs;

import com.api.livros.entities.Livro;

public class LivroResumidoDTO {

    private int idLivro;
    private String titulo;

    public LivroResumidoDTO() {}

    public LivroResumidoDTO(Livro livro) {
        this.idLivro = livro.getIdLivro();
        this.titulo = livro.getTitulo();
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
