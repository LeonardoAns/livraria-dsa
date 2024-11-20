package com.livraria.dsa.application.useCasesImpl.student;

import com.livraria.dsa.adapters.repositories.StudentRepository;
import com.livraria.dsa.core.domain.Student;
import com.livraria.dsa.core.useCases.student.FindAlunoByCpfUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindStudentByCpfUseCaseImpl implements FindAlunoByCpfUseCase {

    private final StudentRepository alunoRepository;

    @Override
    public Student execute(Long cpf) {
        return this.alunoRepository.findByCpf(cpf);
    }
}
