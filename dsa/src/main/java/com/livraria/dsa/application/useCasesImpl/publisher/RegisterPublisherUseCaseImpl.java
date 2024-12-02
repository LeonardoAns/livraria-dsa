package com.livraria.dsa.application.useCasesImpl.publisher;

import com.livraria.dsa.adapters.repositories.PublisherRepository;
import com.livraria.dsa.core.domain.Publisher;
import com.livraria.dsa.core.useCases.publisher.RegisterPublisherUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterPublisherUseCaseImpl implements RegisterPublisherUseCase {

    private final PublisherRepository editoraRepository;

    @Autowired
    public RegisterPublisherUseCaseImpl(PublisherRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    @Override
    public boolean execute(Publisher editora) {
        try {
            this.editoraRepository.save(editora);
        }
        catch (Exception e){
            System.err.println("Erro ao inserir editora");
        }
        return false;
    }
}
