package com.livraria.dsa.application.useCasesImpl.loan;

import com.livraria.dsa.adapters.repositories.LoanRepository;
import com.livraria.dsa.core.domain.Loan;
import com.livraria.dsa.core.useCases.loan.ListActiveLoansUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListActiveLoansUseCaseImpl implements ListActiveLoansUseCase {

    private final LoanRepository emprestimoRepository;

    @Override
    public List<Loan> execute() {
        List<Loan> emprestimosAtivos = this.emprestimoRepository.findAll();
        return emprestimosAtivos
                .stream()
                .filter(Loan::isActive)
                .toList();
    }
}
