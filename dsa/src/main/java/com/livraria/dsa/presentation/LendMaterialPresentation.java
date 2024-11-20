package com.livraria.dsa.presentation;

import com.livraria.dsa.core.domain.Student;
import com.livraria.dsa.core.domain.Loan;
import com.livraria.dsa.core.domain.Material;
import com.livraria.dsa.core.useCases.student.FindAlunoByCpfUseCase;
import com.livraria.dsa.core.useCases.loan.LendMaterialUseCase;
import com.livraria.dsa.core.useCases.material.FindMaterialByTitleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@RequiredArgsConstructor
@Component
public class LendMaterialPresentation {

    private final LendMaterialUseCase emprestarLivroUseCase;
    private final FindMaterialByTitleUseCase findMaterialByTituloUseCase;
    private final FindAlunoByCpfUseCase findAlunoByCpfUseCase;

    public void emprestarMaterial(Scanner sc) {
        System.out.print("Digite o CPF do aluno: ");
        Long cpf = sc.nextLong();
        sc.nextLine();

        Student aluno = findAlunoByCpfUseCase.execute(cpf);
        if (aluno == null) {
            System.out.println("\033[0;31mAluno não encontrado com o CPF: " + cpf + "\033[0m");
            return;
        }

        System.out.print("Digite o título do material: ");
        String titulo = sc.nextLine();
        System.out.println();

        Material material = findMaterialByTituloUseCase.execute(titulo);
        if (material == null) {
            System.out.println("\033[0;31mMaterial não encontrado com o título: " + titulo + "\033[0m");
            return;
        }

        Loan emprestimo = new Loan(aluno, material, true);
        boolean emprestado = emprestarLivroUseCase.execute(emprestimo, aluno);
        if (emprestado) {
            System.out.println("\033[0;32mEmpréstimo realizado com sucesso!\033[0m");
            System.out.println();
        } else {
            System.out.println("\033[0;31mNão foi possível realizar o empréstimo.\033[0m");
        }
    }
}
