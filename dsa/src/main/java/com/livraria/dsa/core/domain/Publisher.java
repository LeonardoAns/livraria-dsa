package com.livraria.dsa.core.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "editora")
    private List<Material> materiaisLancados;

    public Publisher(String nome, List<Material> materiaisLancados) {
        this.nome = nome;
        this.materiaisLancados = materiaisLancados;
    }

    public Publisher(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Editora:" +
                "nome = " + nome + "\n";
    }
}
