package com.livraria.dsa.application.useCasesImpl.author;

import com.livraria.dsa.adapters.repositories.AuthorRepository;
import com.livraria.dsa.core.domain.Author;
import com.livraria.dsa.core.useCases.author.RegisterAuthorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterAuthorUseCaseImpl implements RegisterAuthorUseCase {

    private final AuthorRepository autorRepository;

    @Override
    public boolean execute(Author autor) {
        try {
            this.autorRepository.save(autor);
            return true;
        }
        catch (Exception e){
            System.err.println("Erro ao salvar autor");
        }
        return false;
    }
}
