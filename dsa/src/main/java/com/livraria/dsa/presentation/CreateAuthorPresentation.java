package com.livraria.dsa.presentation;

import com.livraria.dsa.core.domain.Author;
import com.livraria.dsa.core.useCases.author.RegisterAuthorUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CreateAuthorPresentation {

    private final RegisterAuthorUseCase createAutorUseCase;

    @Autowired
    public CreateAuthorPresentation(RegisterAuthorUseCase createAutorUseCase) {
        this.createAutorUseCase = createAutorUseCase;
    }

    public void criarAutor(Scanner sc) {
        System.out.println();
        System.out.print("Digite o nome do Autor: ");
        String nome = sc.nextLine();
        System.out.println();


        boolean resposta = createAutorUseCase.execute(new Author(nome));
        if (resposta) {
            System.out.println("\033[0;32mAutor criado com sucesso!\033[0m");
        } else {
            System.out.println("\033[0;31mOcorreu um erro durante a criação.\033[0m");
        }
    }
}
