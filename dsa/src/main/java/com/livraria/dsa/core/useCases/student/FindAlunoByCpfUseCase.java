package com.livraria.dsa.core.useCases.student;

import com.livraria.dsa.core.domain.Student;

public interface FindAlunoByCpfUseCase {
    Student execute(Long cpf);
}
