package com.livraria.dsa.presentation;

import com.livraria.dsa.core.domain.Publisher;
import com.livraria.dsa.core.useCases.publisher.RegisterPublisherUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CreatePublisherPresentation {

    private final RegisterPublisherUseCase createEditoraUseCase;

    @Autowired
    public CreatePublisherPresentation(RegisterPublisherUseCase createEditoraUseCase) {
        this.createEditoraUseCase = createEditoraUseCase;
    }

    public void criarEditora(Scanner sc) {
        System.out.println();
        System.out.print("Digite o nome da Editora: ");
        String nome = sc.nextLine();
        System.out.println();


        boolean resposta = createEditoraUseCase.execute(new Publisher(nome));
        if (resposta) {
            System.out.println("\033[0;32mEditora criada com sucesso!\033[0m");
        } else {
            System.out.println("\033[0;31mOcorreu um erro durante a criação.\033[0m");
        }
    }
}
