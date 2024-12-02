package com.livraria.dsa.adapters.repositories;

import com.livraria.dsa.core.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByCpf(Long cpf);

    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.materiais WHERE s.cpf = :cpf")
    Student findByCpfWithMateriais(@Param("cpf") Long cpf);
}