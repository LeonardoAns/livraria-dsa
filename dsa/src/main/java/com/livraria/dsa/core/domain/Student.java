package com.livraria.dsa.core.domain;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.List;

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

    public Student(){}

    public Student(String nome, String sobrenome, Long cpf, LocalDate dataNascimento, Long numeroRg, Long matricula) {
        this.name = nome;
        this.lastName = sobrenome;
        this.cpf = cpf;
        this.birthDate = dataNascimento;
        this.rgNumber = numeroRg;
        this.registration = matricula;
    }

    public Student(Long id, String name, String lastName, Long cpf, LocalDate birthDate, Long rgNumber, Long registration, List<Material> materiais) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.rgNumber = rgNumber;
        this.registration = registration;
        this.materiais = materiais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Long getRgNumber() {
        return rgNumber;
    }

    public void setRgNumber(Long rgNumber) {
        this.rgNumber = rgNumber;
    }

    public Long getRegistration() {
        return registration;
    }

    public void setRegistration(Long registration) {
        this.registration = registration;
    }

    public List<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<Material> materiais) {
        this.materiais = materiais;
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