package com.livraria.dsa.application.useCasesImpl.publisher;

import com.livraria.dsa.adapters.repositories.PublisherRepository;
import com.livraria.dsa.core.domain.Publisher;
import com.livraria.dsa.core.useCases.publisher.FindPublisherByNameUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindPublisherByNameUseCaseImpl implements FindPublisherByNameUseCase {

    private final PublisherRepository editoraRepository;

    @Autowired
    public FindPublisherByNameUseCaseImpl(PublisherRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    @Override
    public Publisher execute(String nome) {
        Publisher editora = this.editoraRepository.findByNome(nome);

        if (editora == null) {
            editora = new Publisher();
            editora.setNome(nome);
            editora = this.editoraRepository.save(editora);
        }

        return editora;
    }
}
