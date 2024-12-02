package com.livraria.dsa.adapters.repositories;

import com.livraria.dsa.core.domain.Student;
import com.livraria.dsa.core.domain.Loan;
import com.livraria.dsa.core.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    Loan findByAlunoAndMaterial(Student aluno, Material material);

    @Query("SELECT l FROM Loan l WHERE l.aluno.cpf = :cpf AND l.material.id = :materialId AND l.active = true")
    Optional<Loan> findActiveLoanByAlunoAndMaterial(Long cpf, Long materialId);
}