package com.livraria.dsa.application.useCasesImpl.student;

import com.livraria.dsa.adapters.repositories.StudentRepository;
import com.livraria.dsa.core.domain.Student;
import com.livraria.dsa.core.useCases.student.RegisterStudentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterStudentUseCaseImpl implements RegisterStudentUseCase {

    private final StudentRepository alunoRepository;


    @Override
    public boolean execute(Student aluno) {
        try {
            this.alunoRepository.save(aluno);
            return true;
        }
        catch (Exception e){
            System.err.println("Erro ao Salvar Aluno");
        }
        return false;
    }
}
