package com.livraria.dsa.core.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@DiscriminatorValue("PERIODICO")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Periodical extends Material {

    private String issn;
    private Integer editionNumber;
    private String periodicity;

    public Periodical(String titulo, int ano, int totalExemplares, int exemplaresDisponiveis, Author autor, Publisher editora, String issn, Integer numeroEdicao, String periodicidade) {
        super(titulo, ano, totalExemplares, exemplaresDisponiveis, autor, editora);
        this.issn = issn;
        this.editionNumber = numeroEdicao;
        this.periodicity = periodicidade;
    }

    @Override
    public String toString() {
        return super.toString() +
                "issn = " + issn +"\n"+
                "número da edição = " + editionNumber + "\n"+
                "periodicidade = " + periodicity + "\n";

    }
}