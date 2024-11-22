package com.livraria.dsa.core.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@DiscriminatorValue("LIVRO")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book extends Material {

    private Long isbn;


    public Book(String titulo, int ano, int totalExemplares, int exemplaresDisponiveis, Author autor, Publisher editora, Long isbn) {
        super(titulo, ano, totalExemplares, exemplaresDisponiveis, autor, editora);
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return super.toString() +
                "isbn = " + isbn + "\n";
    }
}
