package com.livraria.dsa.core.domain;

import jakarta.persistence.*;

@Entity
public class Return {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    public Return(){}

    public Return(Student aluno, Material material) {
        this.student = aluno;
        this.material = material;
    }

    public Return(Long id, Student student, Material material) {
        this.id = id;
        this.student = student;
        this.material = material;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", aluno={" +
                "nome='" + student.getName() + '\'' +
                ", sobrenome='" + student.getLastName() + '\'' +
                ", dataNascimento=" + student.getBirthDate() +
                ", numeroRg=" + student.getRgNumber() +
                ", matricula=" + student.getRegistration() +
                '}' +
                ", material={" +
                "id=" + material.getId() +
                ", titulo='" + material.getTitulo() + '\'' +
                ", ano=" + material.getYear() +
                ", totalExemplares=" + material.getTotalCopies() +
                ", exemplaresDisponiveis=" + material.getCopiesAvailable() +
                ", autor=" + material.getAutor() +
                ", editora=" + material.getEditora() +
                "}" +
                '}';
    }
}
