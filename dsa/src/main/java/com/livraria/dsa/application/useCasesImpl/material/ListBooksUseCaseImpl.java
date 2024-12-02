package com.livraria.dsa.application.useCasesImpl.material;

import com.livraria.dsa.adapters.repositories.BookRepository;
import com.livraria.dsa.core.domain.Book;
import com.livraria.dsa.core.useCases.material.ListBooksUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListBooksUseCaseImpl implements ListBooksUseCase {

    private final BookRepository bookRepository;

    @Autowired
    public ListBooksUseCaseImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> execute() {
        return this.bookRepository.findAll();
    }
}
