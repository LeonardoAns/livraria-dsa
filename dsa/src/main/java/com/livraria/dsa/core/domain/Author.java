package com.livraria.dsa.core.domain;

import jakarta.persistence.*;


import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "autor")
    private List<Material> materiaisEscritos;

    public Author(String nome) {
        this.nome = nome;
    }

    public Author() {
    }

    public Author(Long id, String nome, List<Material> materiaisEscritos) {
        this.id = id;
        this.nome = nome;
        this.materiaisEscritos = materiaisEscritos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Material> getMateriaisEscritos() {
        return materiaisEscritos;
    }

    public void setMateriaisEscritos(List<Material> materiaisEscritos) {
        this.materiaisEscritos = materiaisEscritos;
    }

    @Override
    public String toString() {
        return "Autor = " + nome;
    }
}