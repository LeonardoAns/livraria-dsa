package com.livraria.dsa.presentation;

import com.livraria.dsa.adapters.repositories.MaterialRepository;
import com.livraria.dsa.core.domain.Student;
import com.livraria.dsa.core.domain.Loan;
import com.livraria.dsa.core.domain.Material;
import com.livraria.dsa.core.useCases.student.FindAlunoByCpfUseCase;
import com.livraria.dsa.core.useCases.loan.LendMaterialUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@RequiredArgsConstructor
@Component
public class LendMaterialPresentation {

    private final LendMaterialUseCase lendMaterialUseCase;
    private final MaterialRepository materialRepository;
    private final CreateStudentPresentation createStudentPresentation;
    private final FindAlunoByCpfUseCase findAlunoByCpfUseCase;

    public void emprestarMaterial(Scanner scanner) {
        try {
            System.out.println();
            System.out.print("Digite o CPF do aluno: ");
            Long cpf = scanner.nextLong();
            scanner.nextLine();
            System.out.println();

            Student student = findAlunoByCpfUseCase.execute(cpf);
            if (student == null) {
                System.out.println("\033[0;31mAluno não encontrado com o CPF: " + cpf + "\033[0m");
                System.out.println("Insira as informações do aluno novo\n");
                createStudentPresentation.criarAluno(scanner);
                return;
            }

            List<Material> materials = materialRepository.findAll();
            if (materials.isEmpty()) {
                System.out.println("\033[0;31mNenhum material disponível no momento.\033[0m");
                return;
            }

            System.out.println("Materiais disponíveis:");
            materials.forEach(material ->
                    System.out.println("Id: " + material.getId() + " | Título: " + material.getTitulo())
            );

            System.out.print("Digite o ID do material que deseja emprestar: ");
            Long materialId = scanner.nextLong();
            System.out.println();

            Optional<Material> optionalMaterial = materialRepository.findById(materialId);
            if (optionalMaterial.isEmpty()) {
                System.out.println("\033[0;31mMaterial não encontrado com o ID: " + materialId + "\033[0m");
                return;
            }

            Material material = optionalMaterial.get();

            Loan loan = new Loan(student, material, true);
            boolean loanSuccessful = lendMaterialUseCase.execute(loan, student);
            if (loanSuccessful) {
                System.out.println("\033[0;32mEmpréstimo realizado com sucesso!\033[0m");
            } else {
                System.out.println("\033[0;31mNão foi possível realizar o empréstimo.\033[0m");
            }
        } catch (Exception e) {
            System.out.println("\033[0;31mErro ao processar o empréstimo. Verifique os dados inseridos.\033[0m");
        } finally {
            scanner.nextLine();
        }
    }
}