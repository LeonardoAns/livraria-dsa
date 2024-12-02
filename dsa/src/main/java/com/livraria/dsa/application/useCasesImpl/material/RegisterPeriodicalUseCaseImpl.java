package com.livraria.dsa.application.useCasesImpl.material;

import com.livraria.dsa.adapters.repositories.PeriodicalRepository;
import com.livraria.dsa.core.domain.Periodical;
import com.livraria.dsa.core.useCases.material.RegisterPeriodicalUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterPeriodicalUseCaseImpl implements RegisterPeriodicalUseCase {

    private final PeriodicalRepository periodicoRepository;

    @Autowired
    public RegisterPeriodicalUseCaseImpl(PeriodicalRepository periodicoRepository) {
        this.periodicoRepository = periodicoRepository;
    }

    @Override
    public boolean execute(Periodical periodico) {
        try {
            this.periodicoRepository.save(periodico);
            return true;
        }
        catch (Exception e){
            System.err.println("Erro ao inserir Livro");
        }
        return false;
    }
}
