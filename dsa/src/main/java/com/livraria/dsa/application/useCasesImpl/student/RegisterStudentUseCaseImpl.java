package com.livraria.dsa.application.useCasesImpl.student;

import com.livraria.dsa.adapters.repositories.StudentRepository;
import com.livraria.dsa.core.domain.Student;
import com.livraria.dsa.core.useCases.student.RegisterStudentUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterStudentUseCaseImpl implements RegisterStudentUseCase {

    private final StudentRepository alunoRepository;

    @Autowired
    public RegisterStudentUseCaseImpl(StudentRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public boolean execute(Student aluno) {
        try {
            Student alunoByCpf = this.alunoRepository.findByCpf(aluno.getCpf());

            if (alunoByCpf == null) {
                this.alunoRepository.save(aluno);
                return true;
            } else {
                if (alunoByCpf != null) {
                    System.err.println("Aluno com este CPF já está registrado.");
                }
                return false;
            }
        } catch (Exception e) {
            System.err.println("Erro ao salvar aluno: " + e.getMessage());
            return false;
        }
    }
}
