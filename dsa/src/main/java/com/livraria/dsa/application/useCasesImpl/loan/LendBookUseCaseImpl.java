package com.livraria.dsa.application.useCasesImpl.loan;

import com.livraria.dsa.adapters.repositories.StudentRepository;
import com.livraria.dsa.adapters.repositories.LoanRepository;
import com.livraria.dsa.adapters.repositories.MaterialRepository;
import com.livraria.dsa.core.domain.Student;
import com.livraria.dsa.core.domain.Loan;
import com.livraria.dsa.core.useCases.loan.LendMaterialUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LendBookUseCaseImpl implements LendMaterialUseCase {

    private final MaterialRepository materialRepository;
    private final StudentRepository alunoRepository;
    private final LoanRepository emprestimoRepository;

    @Override
    @Transactional
    public boolean execute(Loan emprestimo, Student aluno) {
        try {
            aluno = alunoRepository.findById(aluno.getId()).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
            System.out.println(aluno);

            if (emprestimo.getMaterial().getCopiesAvailable() > 0) {
                emprestimo.getMaterial().setCopiesAvailable(emprestimo.getMaterial().getCopiesAvailable() - 1);
                System.out.println("Número disponível para empréstimo após emprestimo: " + emprestimo.getMaterial().getCopiesAvailable());

                aluno.getMateriais().add(emprestimo.getMaterial());

                this.materialRepository.save(emprestimo.getMaterial());
                this.alunoRepository.save(aluno);
                this.emprestimoRepository.save(emprestimo);

                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
