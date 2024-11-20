package com.livraria.dsa.core.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public Loan(Student aluno, Material material, boolean ativo) {
        this.aluno = aluno;
        this.material = material;
        this.active = ativo;
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
                "        "+ material.getAutor() +
                "        " + material.getEditora()+
                "        ativo=" + active + "\n";
    }

}

