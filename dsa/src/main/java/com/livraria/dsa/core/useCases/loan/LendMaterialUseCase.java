package com.livraria.dsa.core.useCases.loan;

import com.livraria.dsa.core.domain.Student;
import com.livraria.dsa.core.domain.Loan;

public interface LendMaterialUseCase {
    boolean execute(Loan emprestimo, Student aluno);
}
