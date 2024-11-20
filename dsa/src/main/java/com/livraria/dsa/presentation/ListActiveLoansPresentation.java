package com.livraria.dsa.presentation;

import com.livraria.dsa.core.domain.Loan;
import com.livraria.dsa.core.useCases.loan.ListActiveLoansUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ListActiveLoansPresentation {

    private final ListActiveLoansUseCase listarEmprestimosAtivosUseCase;

    public void listarEmprestimosAtivos() {
        List<Loan> emprestimosAtivos = listarEmprestimosAtivosUseCase.execute();
        if (emprestimosAtivos.isEmpty()) {
            System.out.println("\033[0;31mNenhum empréstimo ativo no momento.\033[0m");
        } else {
            emprestimosAtivos.forEach(emprestimo -> {
                System.out.println(emprestimo);
            });
        }
    }
}
