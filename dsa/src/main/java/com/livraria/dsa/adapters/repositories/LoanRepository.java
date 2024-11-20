package com.livraria.dsa.adapters.repositories;

import com.livraria.dsa.core.domain.Student;
import com.livraria.dsa.core.domain.Loan;
import com.livraria.dsa.core.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    Loan findByAlunoAndMaterial(Student aluno, Material material);
}
