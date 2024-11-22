package com.livraria.dsa.presentation;

import com.livraria.dsa.adapters.repositories.AuthorRepository;
import com.livraria.dsa.adapters.repositories.PublisherRepository;
import com.livraria.dsa.core.domain.Author;
import com.livraria.dsa.core.domain.Publisher;
import com.livraria.dsa.core.domain.Book;
import com.livraria.dsa.core.useCases.author.RegisterAuthorUseCase;
import com.livraria.dsa.core.useCases.author.FindAuthorByNameUseCase;
import com.livraria.dsa.core.useCases.publisher.RegisterPublisherUseCase;
import com.livraria.dsa.core.useCases.publisher.FindPublisherByNameUseCase;
import com.livraria.dsa.core.useCases.material.RegisterMaterialUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@RequiredArgsConstructor
@Component
public class CreateBookPresentation {

    private final AuthorRepository autorRepository;
    private final RegisterAuthorUseCase createAutorUseCase;
    private final FindAuthorByNameUseCase findAutorByNomeUseCase;
    private final FindPublisherByNameUseCase findEditoraByNameUseCase;
    private final RegisterPublisherUseCase createEditoraUseCase;
    private final RegisterMaterialUseCase createLivroUseCase;
    private final PublisherRepository publisherRepository;

    public void criarLivro(Scanner sc) {
        System.out.println();
        System.out.print("Digite o título do livro: ");
        String titulo = sc.nextLine();

        System.out.print("Digite o ano de publicação: ");
        int ano = sc.nextInt();

        System.out.print("Digite o total de exemplares: ");
        int totalExemplares = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite o total de exemplares disponíveis: ");
        int exemplaresDisponiveis = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite o nome do autor: ");
        String nomeAutor = sc.nextLine();

        System.out.print("Digite o nome da editora: ");
        String nomeEditora = sc.nextLine();

        System.out.print("Digite o ISBN: ");
        Long isbn = sc.nextLong();
        System.out.println();


        Author autor = autorRepository.findByNome(nomeAutor);
        if (autor == null) {
            createAutorUseCase.execute(new Author(nomeAutor));
            autor = findAutorByNomeUseCase.execute(nomeAutor);
            System.out.println("\033[0;33mAutor não encontrado, autor com o nome de " + autor.getNome() + " criado\033[0m");
        }

        Publisher editora = publisherRepository.findByNome(nomeEditora);
        if (editora == null) {
            createEditoraUseCase.execute(new Publisher(nomeEditora));
            editora = findEditoraByNameUseCase.execute(nomeEditora);
            System.out.println("\033[0;33mEditora não encontrada, editora com o nome de " + editora.getNome() + " criada\033[0m");
        }

        Book livro = new Book(
                titulo,
                ano,
                totalExemplares,
                exemplaresDisponiveis,
                autor,
                editora,
                isbn
        );

        boolean resposta = createLivroUseCase.execute(livro);
        if (resposta) {
            System.out.println("\033[0;32mLivro criado com sucesso!\033[0m");
            System.out.println();
        } else {
            System.out.println("\033[0;31mOcorreu um erro durante a criação.\033[0m");
        }
    }
}
