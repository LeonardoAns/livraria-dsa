package com.livraria.dsa.presentation;

import com.livraria.dsa.core.domain.Loan;
import com.livraria.dsa.core.useCases.loan.ListActiveLoansUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListActiveLoansPresentation {

    private final ListActiveLoansUseCase listarEmprestimosAtivosUseCase;

    @Autowired
    public ListActiveLoansPresentation(ListActiveLoansUseCase listarEmprestimosAtivosUseCase) {
        this.listarEmprestimosAtivosUseCase = listarEmprestimosAtivosUseCase;
    }

    public void listarEmprestimosAtivos() {
        System.out.println();
        List<Loan> emprestimosAtivos = listarEmprestimosAtivosUseCase.execute();
        if (emprestimosAtivos.isEmpty()) {
            System.out.println();
            System.out.println("\033[0;31mNenhum empréstimo ativo no momento.\033[0m");
            System.out.println();
        } else {
            emprestimosAtivos.forEach(emprestimo -> {
                System.out.println(emprestimo);
            });
        }
    }
}
