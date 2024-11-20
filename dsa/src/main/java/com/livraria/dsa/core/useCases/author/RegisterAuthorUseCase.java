package com.livraria.dsa.core.useCases.author;

import com.livraria.dsa.core.domain.Author;

public interface RegisterAuthorUseCase {
    boolean execute(Author autor);
}
