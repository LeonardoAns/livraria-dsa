package com.livraria.dsa.application.useCasesImpl.student;

import com.livraria.dsa.adapters.repositories.StudentRepository;
import com.livraria.dsa.core.domain.Student;
import com.livraria.dsa.core.useCases.student.FindAlunoByCpfUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindStudentByCpfUseCaseImpl implements FindAlunoByCpfUseCase {

    private final StudentRepository alunoRepository;

    @Autowired
    public FindStudentByCpfUseCaseImpl(StudentRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public Student execute(Long cpf) {
        return this.alunoRepository.findByCpf(cpf);
    }
}
