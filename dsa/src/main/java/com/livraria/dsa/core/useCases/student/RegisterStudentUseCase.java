package com.livraria.dsa.core.useCases.student;

import com.livraria.dsa.core.domain.Student;

public interface RegisterStudentUseCase {
    boolean execute(Student aluno);
}
