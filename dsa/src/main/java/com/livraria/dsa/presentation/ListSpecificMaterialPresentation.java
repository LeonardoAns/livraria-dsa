package com.livraria.dsa.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class ListSpecificMaterialPresentation {

    private final ListBookPresentation listBooksPresentation;
    private final ListTPeriodicalsPresentation listPeriodicalsPresentation;

    public void listarMateriais(Scanner sc){
        System.out.println("1. Listar Livros \n2. Listar Periodicos");
        int escolha = sc.nextInt();

        switch (escolha){
            case 1 -> {
                listBooksPresentation.listarLivros();
            }
            case 2 -> {
                listPeriodicalsPresentation.listarPeriodicos();
            }
            default -> {
                System.out.println("Por favor, insira um número válido.");
            }
        }
    }
}