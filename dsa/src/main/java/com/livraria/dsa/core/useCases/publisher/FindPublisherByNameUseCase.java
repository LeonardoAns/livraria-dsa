package com.livraria.dsa.core.useCases.publisher;

import com.livraria.dsa.core.domain.Publisher;

public interface FindPublisherByNameUseCase {
    Publisher execute(String nome);
}
