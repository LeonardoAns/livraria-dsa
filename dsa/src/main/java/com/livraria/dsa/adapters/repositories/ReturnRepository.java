package com.livraria.dsa.adapters.repositories;

import com.livraria.dsa.core.domain.Return;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnRepository extends JpaRepository<Return, Long> {
}
