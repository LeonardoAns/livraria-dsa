package com.livraria.dsa.adapters.repositories;

import com.livraria.dsa.core.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByNome(String nome);
}
