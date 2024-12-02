package com.livraria.dsa.core.domain;

import jakarta.persistence.*;


@Entity
public class Book extends Material {

    private Long isbn;


    public Book(String titulo, int ano, int totalExemplares, int exemplaresDisponiveis, Author autor, Publisher editora, Long isbn) {
        super(titulo, ano, totalExemplares, exemplaresDisponiveis, autor, editora);
        this.isbn = isbn;
    }

   public Book(){}

    public Book(Long isbn) {
        this.isbn = isbn;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return super.toString() +
                "isbn = " + isbn + "\n";
    }
}
