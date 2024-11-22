package com.livraria.dsa.presentation;

import com.livraria.dsa.core.domain.Student;
import com.livraria.dsa.core.useCases.student.RegisterStudentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;

@RequiredArgsConstructor
@Component
public class CreateStudentPresentation {

    private final RegisterStudentUseCase createAlunoUseCase;

    public void criarAluno(Scanner sc) {
        System.out.println();
        System.out.print("Digite o nome do aluno: ");
        String nome = sc.nextLine();

        System.out.print("Digite o sobrenome do aluno: ");
        String sobrenome = sc.nextLine();

        System.out.print("Digite o CPF do aluno: ");
        Long cpf = sc.nextLong();
        sc.nextLine();
        System.out.println();


        System.out.print("Digite a data de nascimento do aluno (yyyy-mm-dd): ");
        String dataNascimentoString = sc.nextLine();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoString);

        System.out.print("Digite o número do RG do aluno: ");
        Long numeroRg = sc.nextLong();

        System.out.print("Digite a matrícula do aluno: ");
        Long matricula = sc.nextLong();

        createAlunoUseCase.execute(new Student(
                nome,
                sobrenome,
                cpf,
                dataNascimento,
                numeroRg,
                matricula
        ));
        System.out.println("\033[0;32mAluno criado com sucesso!\033[0m");
    }
}
