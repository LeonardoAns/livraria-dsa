package com.livraria.dsa.adapters.repositories;

import com.livraria.dsa.core.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Publisher findByNome(String nome);
}
