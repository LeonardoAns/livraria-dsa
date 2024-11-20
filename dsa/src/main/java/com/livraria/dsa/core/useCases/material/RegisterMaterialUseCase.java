package com.livraria.dsa.core.useCases.material;

import com.livraria.dsa.core.domain.Book;

public interface RegisterMaterialUseCase {
    boolean execute(Book livro);
}
