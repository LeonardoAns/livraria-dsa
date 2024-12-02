package com.livraria.dsa.core.domain;

import jakarta.persistence.*;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Student aluno;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    private boolean active;

    public Loan() {
    }

    public Loan(Student aluno, Material material, boolean ativo) {
        this.aluno = aluno;
        this.material = material;
        this.active = ativo;
    }

    public Loan(Long id, Student aluno, Material material, boolean active) {
        this.id = id;
        this.aluno = aluno;
        this.material = material;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getAluno() {
        return aluno;
    }

    public void setAluno(Student aluno) {
        this.aluno = aluno;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Emprestimo { \n" +
                "    id=" + id + ",\n" +
                "    aluno={\n" +
                "        nome='" + aluno.getName() + "',\n" +
                "        sobrenome='" + aluno.getLastName() + "',\n" +
                "        dataNascimento=" + aluno.getBirthDate() + ",\n" +
                "        numeroRg='" + aluno.getRgNumber() + "',\n" +
                "        matricula='" + aluno.getRegistration() + "'\n" +
                "    },\n" +
                "    material={\n" +
                "        id=" + material.getId() + ",\n" +
                "        titulo='" + material.getTitulo() + "',\n" +
                "        ano=" + material.getYear() + ",\n" +
                "        totalExemplares=" + material.getTotalCopies() + ",\n" +
                "        exemplaresDisponiveis=" + material.getCopiesAvailable() + ",\n" +
                "        "+ material.getAutor() + "\n" +
                "        " + material.getEditora()+ "\n" +
                "        ativo=" + active + "\n";
    }

}