package com.livraria.dsa.application.useCasesImpl.material;

import com.livraria.dsa.adapters.repositories.PeriodicalRepository;
import com.livraria.dsa.core.domain.Periodical;
import com.livraria.dsa.core.useCases.material.ListPeriodicalsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ListPeriodicalsUseCaseImpl implements ListPeriodicalsUseCase {

    private final PeriodicalRepository periodicalRepository;

    @Autowired
    public ListPeriodicalsUseCaseImpl(PeriodicalRepository periodicalRepository) {
        this.periodicalRepository = periodicalRepository;
    }

    @Override
    public List<Periodical> execute() {
        return this.periodicalRepository.findAll();
    }
}
