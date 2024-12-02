package com.livraria.dsa.application.useCasesImpl.loan;

import com.livraria.dsa.adapters.repositories.LoanRepository;
import com.livraria.dsa.core.domain.Loan;
import com.livraria.dsa.core.useCases.loan.ListActiveLoansUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListActiveLoansUseCaseImpl implements ListActiveLoansUseCase {

    private final LoanRepository emprestimoRepository;

    @Autowired
    public ListActiveLoansUseCaseImpl(LoanRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    @Override
    public List<Loan> execute() {
        List<Loan> emprestimosAtivos = this.emprestimoRepository.findAll();
        return emprestimosAtivos
                .stream()
                .filter(Loan::isActive)
                .toList();
    }
}
