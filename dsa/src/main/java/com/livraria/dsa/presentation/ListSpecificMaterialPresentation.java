package com.livraria.dsa.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ListSpecificMaterialPresentation {

    private final ListBookPresentation listBooksPresentation;
    private final ListPeriodicalsPresentation listPeriodicalsPresentation;

    @Autowired
    public ListSpecificMaterialPresentation(ListBookPresentation listBooksPresentation, ListPeriodicalsPresentation listPeriodicalsPresentation) {
        this.listBooksPresentation = listBooksPresentation;
        this.listPeriodicalsPresentation = listPeriodicalsPresentation;
    }

    public void listarMateriais(Scanner sc){
        System.out.println();
        System.out.println("1. Listar Livros \n2. Listar Periodicos");
        int escolha = sc.nextInt();
        System.out.println();

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