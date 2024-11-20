package com.livraria.dsa.adapters.repositories;

import com.livraria.dsa.core.domain.Periodical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodicalRepository extends JpaRepository<Periodical, Long> {
}
