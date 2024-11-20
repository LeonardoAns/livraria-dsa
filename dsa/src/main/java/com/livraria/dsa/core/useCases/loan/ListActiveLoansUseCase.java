package com.livraria.dsa.core.useCases.loan;

import com.livraria.dsa.core.domain.Loan;

import java.util.List;

public interface ListActiveLoansUseCase {
    List<Loan> execute();
}
