package com.livraria.dsa.presentation;

import com.livraria.dsa.core.domain.Return;
import com.livraria.dsa.core.domain.Student;
import com.livraria.dsa.core.domain.Material;
import com.livraria.dsa.core.useCases.student.FindAlunoByCpfUseCase;
import com.livraria.dsa.core.useCases.material.FindMaterialByTitleUseCase;
import com.livraria.dsa.core.useCases.student.ReturnMaterialUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@RequiredArgsConstructor
@Component
public class ReturnMaterialPresentation {

    private final FindAlunoByCpfUseCase findAlunoByCpfUseCase;
    private final FindMaterialByTitleUseCase findMaterialByTituloUseCase;
    private final ReturnMaterialUseCase devolverLivroUseCase;

    public void devolverMaterial(Scanner sc) {
        System.out.println();
        System.out.println("Digite o CPF do aluno: ");
        Long cpf = sc.nextLong();
        sc.nextLine();

        System.out.print("Digite o título do material: ");
        String titulo = sc.nextLine().trim();
        System.out.println();

        Student aluno = findAlunoByCpfUseCase.execute(cpf);
        Material material = findMaterialByTituloUseCase.execute(titulo);

        if (aluno == null || material == null) {
            System.out.println("Aluno ou material não encontrado.");
            return;
        }


        boolean resposta = devolverLivroUseCase.execute(new Return(aluno, material));

        if (resposta) {
            System.out.println("Material devolvido com sucesso!");
        } else {
            System.out.println("Erro ao devolver material.");
        }
    }
}
