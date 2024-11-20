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

    public Material(String titulo, int ano, int totalExemplares, int exemplaresDisponiveis, Author autor, Publisher editora) {
        this.titulo = titulo;
        this.year = ano;
        this.totalCopies = totalExemplares;
        this.copiesAvailable = exemplaresDisponiveis;
        this.autor = autor;
        this.editora = editora;
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
