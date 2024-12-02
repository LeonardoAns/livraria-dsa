package com.livraria.dsa.application.useCasesImpl.author;

import com.livraria.dsa.adapters.repositories.AuthorRepository;
import com.livraria.dsa.core.domain.Author;
import com.livraria.dsa.core.useCases.author.FindAuthorByNameUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindAuthorByNameUseCaseImpl implements FindAuthorByNameUseCase {

    private final AuthorRepository autorRepository;

    @Autowired
    public FindAuthorByNameUseCaseImpl(AuthorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public Author execute(String nome) {
        Author autor = autorRepository.findByNome(nome);

        if (autor == null) {
            autor = new Author();
            autor.setNome(nome);
            autor = autorRepository.save(autor);
        }

        return autor;
    }
}
