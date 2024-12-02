package com.livraria.dsa.presentation;

import com.livraria.dsa.adapters.repositories.LoanRepository;
import com.livraria.dsa.adapters.repositories.MaterialRepository;
import com.livraria.dsa.adapters.repositories.StudentRepository;
import com.livraria.dsa.core.domain.Loan;
import com.livraria.dsa.core.domain.Return;
import com.livraria.dsa.core.domain.Student;
import com.livraria.dsa.core.domain.Material;
import com.livraria.dsa.core.useCases.student.ReturnMaterialUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ReturnMaterialPresentation {

    private final MaterialRepository materialRepository;
    private final LoanRepository loanRepository;
    private final ReturnMaterialUseCase devolverLivroUseCase;
    private final StudentRepository studentRepository;

    @Autowired
    public ReturnMaterialPresentation(MaterialRepository materialRepository, LoanRepository loanRepository, ReturnMaterialUseCase devolverLivroUseCase, StudentRepository studentRepository) {
        this.materialRepository = materialRepository;
        this.loanRepository = loanRepository;
        this.devolverLivroUseCase = devolverLivroUseCase;
        this.studentRepository = studentRepository;
    }

    public void devolverMaterial(Scanner sc) {
        System.out.println();
        System.out.println("Digite o CPF do aluno: ");
        Long cpf = sc.nextLong();
        sc.nextLine();

        Student aluno = studentRepository.findByCpfWithMateriais(cpf);
        if (aluno == null) {
            System.out.println("\033[0;31mAluno não encontrado com o CPF: " + cpf + "\033[0m");
            return;
        }
        System.out.println("Materiais emprestados para " + aluno.getName());
        aluno.getMateriais().forEach(material ->
                System.out.println("Id: " + material.getId() + " | Título: " + material.getTitulo())
        );

        System.out.print("Digite o Id do material: ");
        Long materialId = sc.nextLong();
        System.out.println();



        Material material = materialRepository.findById(materialId).orElse(null);
        if (material == null) {
            System.out.println("\033[0;31mMaterial não encontrado com o ID: " + materialId + "\033[0m");
            return;
        }

        Loan emprestimo = this.loanRepository.findActiveLoanByAlunoAndMaterial(cpf,materialId).orElse(null);
        if(emprestimo == null){
            System.out.println("Emprestimo não ecnontrado");
            return;
        }
        this.loanRepository.delete(emprestimo);

        boolean resposta = devolverLivroUseCase.execute(new Return(aluno, material));
        if (resposta) {
            System.out.println("\033[0;32mMaterial devolvido com sucesso!\033[0m");
        } else {
            System.out.println("\033[0;31mErro ao devolver material.\033[0m");
        }
    }
}