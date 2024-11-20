package com.livraria.dsa.presentation;

import com.livraria.dsa.core.domain.Book;
import com.livraria.dsa.core.useCases.material.ListBooksUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListBookPresentation {

    private final ListBooksUseCase listBooksUseCase;

    public void listarLivros(){
        System.out.println("Lista dos Materiais do tipo livro");
        List<Book> livros = this.listBooksUseCase.execute();

        livros.forEach(livro -> {
            System.out.println(livro.toString() + "\n");
        });
    }
}