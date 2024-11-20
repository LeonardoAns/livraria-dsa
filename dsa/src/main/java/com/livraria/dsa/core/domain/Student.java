package com.livraria.dsa.core.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private Long cpf;
    private LocalDate birthDate;
    private Long rgNumber;
    private Long registration;
    @ManyToMany
    @JoinTable(
            name = "aluno_material",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id")
    )
    private List<Material> materiais;


    public Student(String nome, String sobrenome, Long cpf, LocalDate dataNascimento, Long numeroRg, Long matricula) {
        this.name = nome;
        this.lastName = sobrenome;
        this.cpf = cpf;
        this.birthDate = dataNascimento;
        this.rgNumber = numeroRg;
        this.registration = matricula;
    }

    @Override
    public String toString() {
        return "Aluno encontrado " +
                "nome = " + name + "\n" +
                "sobrenome = " + lastName + "\n" +
                "cpf=" + cpf + "\n" +
                "dataNascimento=" + birthDate + "\n" +
                "numeroRg=" + rgNumber + "\n" +
                "matricula=" + registration + "\n";
    }
}