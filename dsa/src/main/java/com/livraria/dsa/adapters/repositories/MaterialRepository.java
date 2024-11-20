package com.livraria.dsa.adapters.repositories;

import com.livraria.dsa.core.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    Material findByTitulo(String titulo);
}
