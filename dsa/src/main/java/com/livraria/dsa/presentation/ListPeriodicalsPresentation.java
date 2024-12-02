package com.livraria.dsa.presentation;

import com.livraria.dsa.core.domain.Periodical;
import com.livraria.dsa.core.useCases.material.ListPeriodicalsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListPeriodicalsPresentation {

    private final ListPeriodicalsUseCase listPeriodicalsUseCase;

    @Autowired
    public ListPeriodicalsPresentation(ListPeriodicalsUseCase listPeriodicalsUseCase) {
        this.listPeriodicalsUseCase = listPeriodicalsUseCase;
    }

    public void listarPeriodicos(){
        System.out.println();
        System.out.println("Lista dos Materiais do tipo livro");
        List<Periodical> periodicos = this.listPeriodicalsUseCase.execute();

        periodicos.forEach(periodico -> {
            System.out.println(periodico.toString() + "\n");
        });
    }
}