package com.livraria.dsa.core.domain;

import jakarta.persistence.*;


import java.util.List;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "editora")
    private List<Material> materiaisLancados;

    public Publisher(){}

    public Publisher(String nome, List<Material> materiaisLancados) {
        this.nome = nome;
        this.materiaisLancados = materiaisLancados;
    }

    public Publisher(String nome) {
        this.nome = nome;
    }

    public Publisher(Long id, String nome, List<Material> materiaisLancados) {
        this.id = id;
        this.nome = nome;
        this.materiaisLancados = materiaisLancados;
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

    public List<Material> getMateriaisLancados() {
        return materiaisLancados;
    }

    public void setMateriaisLancados(List<Material> materiaisLancados) {
        this.materiaisLancados = materiaisLancados;
    }

    @Override
    public String toString() {
        return "Editora = " + nome;
    }
}