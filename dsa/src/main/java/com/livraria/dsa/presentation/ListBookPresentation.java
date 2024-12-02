package com.livraria.dsa.presentation;

import com.livraria.dsa.core.domain.Book;
import com.livraria.dsa.core.useCases.material.ListBooksUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListBookPresentation {

    private final ListBooksUseCase listBooksUseCase;

    @Autowired
    public ListBookPresentation(ListBooksUseCase listBooksUseCase) {
        this.listBooksUseCase = listBooksUseCase;
    }

    public void listarLivros(){
        System.out.println();
        System.out.println("Lista dos Materiais do tipo livro");
        List<Book> livros = this.listBooksUseCase.execute();

        livros.forEach(livro -> {
            System.out.println(livro.toString() + "\n");
        });
    }
}