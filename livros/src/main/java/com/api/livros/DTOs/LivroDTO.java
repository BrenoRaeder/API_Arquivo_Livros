package com.api.livros.DTOs;

import com.api.livros.entities.Autor;
import com.api.livros.entities.Livro;

import java.util.Date;

public class LivroDTO {

    private int idLivro;
    private String titulo;
    private Date dataInicio;
    private Date dataTermino;
    private int qtdPaginas;
    private String imgCapa;
    AutorDTO autorDTO;

    public LivroDTO() {}


    public LivroDTO(Livro livro) {
        this.idLivro = livro.getIdLivro();
        this.titulo = livro.getTitulo();
        this.dataInicio = livro.getDataInicio();
        this.dataTermino = livro.getDataTermino();
        this.qtdPaginas = livro.getQtdPaginas();
        this.imgCapa = livro.getImgCapa();
        if(livro.getAutor() == null) {
            this.autorDTO = null;
        } else {
            this.autorDTO = new AutorDTO(livro.getAutor());
        }
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public int getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(int qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    public String getImgCapa() {
        return imgCapa;
    }

    public void setImgCapa(String imgCapa) {
        this.imgCapa = imgCapa;
    }

    public AutorDTO getAutorDTO() {
        return autorDTO;
    }

    public void setAutorDTO(AutorDTO autorDTO) {
        this.autorDTO = autorDTO;
    }
}
