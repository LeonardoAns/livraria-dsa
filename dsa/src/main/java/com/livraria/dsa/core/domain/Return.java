package com.livraria.dsa.core.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public Return(Student aluno, Material material) {
        this.student = aluno;
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
