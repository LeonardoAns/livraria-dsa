package com.livraria.dsa.application.useCasesImpl.loan;

import com.livraria.dsa.adapters.repositories.ReturnRepository;
import com.livraria.dsa.core.domain.Return;
import com.livraria.dsa.core.useCases.loan.ListReturnsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListReturnsUseCaseImpl implements ListReturnsUseCase {

    private final ReturnRepository devolucaoRepository;

    @Autowired
    public ListReturnsUseCaseImpl(ReturnRepository devolucaoRepository) {
        this.devolucaoRepository = devolucaoRepository;
    }

    @Override
    public List<Return> execute() {
        return this.devolucaoRepository.findAll();
    }
}
