package com.livraria.dsa.core.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private int year;

    private int totalCopies;
    private int copiesAvailable;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Author autor;

    @ManyToOne
    @JoinColumn(name = "editora_id")
    private Publisher editora;


    @ManyToMany(mappedBy = "materiais")
    private List<Student> alunos;

    private boolean borrowed;

    public Material() {
    }

    public Material(String titulo, int ano, int totalExemplares, int exemplaresDisponiveis, Author autor, Publisher editora) {
        this.titulo = titulo;
        this.year = ano;
        this.totalCopies = totalExemplares;
        this.copiesAvailable = exemplaresDisponiveis;
        this.autor = autor;
        this.editora = editora;
    }

    public Material(Long id, String titulo, int year, int totalCopies, int copiesAvailable, Author autor, Publisher editora, List<Student> alunos, boolean borrowed) {
        this.id = id;
        this.titulo = titulo;
        this.year = year;
        this.totalCopies = totalCopies;
        this.copiesAvailable = copiesAvailable;
        this.autor = autor;
        this.editora = editora;
        this.alunos = alunos;
        this.borrowed = borrowed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public Author getAutor() {
        return autor;
    }

    public void setAutor(Author autor) {
        this.autor = autor;
    }

    public Publisher getEditora() {
        return editora;
    }

    public void setEditora(Publisher editora) {
        this.editora = editora;
    }

    public List<Student> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Student> alunos) {
        this.alunos = alunos;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return "id = " + id + "\n" +
                "titulo = " + titulo + "\n" +
                "ano = " + year + "\n" +
                "autor = " + autor + "\n" +
                "editora = " + editora + "\n" +
                "emprestado = " + borrowed +"\n";
    }
}
