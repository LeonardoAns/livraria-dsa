package com.livraria.dsa.presentation;

import com.livraria.dsa.adapters.repositories.AuthorRepository;
import com.livraria.dsa.core.domain.Author;
import com.livraria.dsa.core.domain.Publisher;
import com.livraria.dsa.core.domain.Periodical;
import com.livraria.dsa.core.useCases.author.RegisterAuthorUseCase;
import com.livraria.dsa.core.useCases.author.FindAuthorByNameUseCase;
import com.livraria.dsa.core.useCases.publisher.RegisterPublisherUseCase;
import com.livraria.dsa.core.useCases.publisher.FindPublisherByNameUseCase;
import com.livraria.dsa.core.useCases.material.RegisterPeriodicalUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@RequiredArgsConstructor
@Component
public class CreatePeriodicalPresentation {

    private final AuthorRepository autorRepository;
    private final RegisterAuthorUseCase createAutorUseCase;
    private final FindAuthorByNameUseCase findAutorByNomeUseCase;
    private final FindPublisherByNameUseCase findEditoraByNameUseCase;
    private final RegisterPublisherUseCase createEditoraUseCase;
    private final RegisterPeriodicalUseCase createPeriodicoUseCase;

    public void criarPeriodico(Scanner sc) {
        System.out.print("Digite o título do periódico: ");
        String titulo = sc.nextLine();

        System.out.print("Digite o ano de publicação: ");
        int ano = sc.nextInt();

        System.out.print("Digite o total de exemplares: ");
        int totalExemplares = sc.nextInt();

        System.out.print("Digite o total de exemplares disponíveis: ");
        int exemplaresDisponiveis = sc.nextInt();

        System.out.print("Digite o nome do autor: ");
        String nomeAutor = sc.nextLine();

        System.out.print("Digite o nome da editora: ");
        String nomeEditora = sc.nextLine();

        System.out.print("Digite o ISSN: ");
        String issn = sc.nextLine();

        System.out.print("Digite o número da edição: ");
        int edicao = sc.nextInt();

        System.out.print("Digite a frequência/periodicidade (ex: 2 semanas): ");
        String periodicidade = sc.nextLine();


        Author autor = autorRepository.findByNome(nomeAutor);
        if (autor == null) {
            createAutorUseCase.execute(new Author(nomeAutor));
            autor = findAutorByNomeUseCase.execute(nomeAutor);
            System.out.println("\033[0;33mAutor não encontrado, autor com o nome de " + autor.getNome() + " criado.\033[0m");
        }


        Publisher editora = findEditoraByNameUseCase.execute(nomeEditora);
        if (editora == null) {
            createEditoraUseCase.execute(new Publisher(nomeEditora));
            editora = findEditoraByNameUseCase.execute(nomeEditora);
            System.out.println("\033[0;33mEditora não encontrada, editora com o nome de " + editora.getNome() + " criada.\033[0m");
        }


        Periodical periodico = new Periodical(
                titulo,
                ano,
                totalExemplares,
                exemplaresDisponiveis,
                autor,
                editora,
                issn,
                edicao,
                periodicidade
        );

        boolean resposta = createPeriodicoUseCase.execute(periodico);
        if (resposta) {
            System.out.println("\033[0;32mPeriódico criado com sucesso!\033[0m");
        } else {
            System.out.println("\033[0;31mOcorreu um erro durante a criação.\033[0m");
        }
    }

}
