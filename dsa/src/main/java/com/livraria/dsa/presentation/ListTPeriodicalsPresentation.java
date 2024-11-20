package com.livraria.dsa.presentation;

import com.livraria.dsa.core.domain.Periodical;
import com.livraria.dsa.core.useCases.material.ListPeriodicalsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListTPeriodicalsPresentation {

    private final ListPeriodicalsUseCase listPeriodicalsUseCase;

    public void listarPeriodicos(){
        System.out.println("Lista dos Materiais do tipo livro");
        List<Periodical> periodicos = this.listPeriodicalsUseCase.execute();

        periodicos.forEach(periodico -> {
            System.out.println(periodico.toString() + "\n");
        });
    }
}