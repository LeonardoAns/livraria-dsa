package com.livraria.dsa.core.useCases.material;

import com.livraria.dsa.core.domain.Book;

import java.util.List;

public interface ListBooksUseCase {
    List<Book> execute();
}
