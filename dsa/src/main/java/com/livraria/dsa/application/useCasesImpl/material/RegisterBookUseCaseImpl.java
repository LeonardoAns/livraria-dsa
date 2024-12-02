package com.livraria.dsa.application.useCasesImpl.material;

import com.livraria.dsa.adapters.repositories.AuthorRepository;
import com.livraria.dsa.adapters.repositories.PublisherRepository;
import com.livraria.dsa.adapters.repositories.BookRepository;
import com.livraria.dsa.adapters.repositories.MaterialRepository;
import com.livraria.dsa.core.domain.Book;
import com.livraria.dsa.core.useCases.author.RegisterAuthorUseCase;
import com.livraria.dsa.core.useCases.publisher.RegisterPublisherUseCase;
import com.livraria.dsa.core.useCases.material.RegisterMaterialUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterBookUseCaseImpl implements RegisterMaterialUseCase {

    private final BookRepository livroRepository;
    private final MaterialRepository materialRepository;
    private final PublisherRepository editoraRepository;
    private final AuthorRepository autorRepository;
    private final RegisterPublisherUseCase createEditoraUseCase;
    private final RegisterAuthorUseCase createAutorUseCase;

    @Autowired
    public RegisterBookUseCaseImpl(BookRepository livroRepository, MaterialRepository materialRepository, PublisherRepository editoraRepository, AuthorRepository autorRepository, RegisterPublisherUseCase createEditoraUseCase, RegisterAuthorUseCase createAutorUseCase) {
        this.livroRepository = livroRepository;
        this.materialRepository = materialRepository;
        this.editoraRepository = editoraRepository;
        this.autorRepository = autorRepository;
        this.createEditoraUseCase = createEditoraUseCase;
        this.createAutorUseCase = createAutorUseCase;
    }

    @Override
    public boolean execute(Book livro) {
        try {
                this.livroRepository.save(livro);
                return true;
        }
        catch (Exception e){
            System.err.println("Erro ao inserir Livro");
        }
        return false;
    }
}
