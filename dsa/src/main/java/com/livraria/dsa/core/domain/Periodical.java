package com.livraria.dsa.core.domain;

import jakarta.persistence.*;
import java.util.List;


@Entity
public class Periodical extends Material {

    private Long issn;
    private Integer editionNumber;
    private String periodicity;

    public Periodical(){}

    public Periodical(String titulo, int ano, int totalExemplares, int exemplaresDisponiveis, Author autor, Publisher editora, Long issn, Integer numeroEdicao, String periodicidade) {
        super(titulo, ano, totalExemplares, exemplaresDisponiveis, autor, editora);
        this.issn = issn;
        this.editionNumber = numeroEdicao;
        this.periodicity = periodicidade;
    }

    public Periodical(Long id, String titulo, int year, int totalCopies, int copiesAvailable, Author autor, Publisher editora, List<Student> alunos, boolean borrowed, Long issn, Integer editionNumber, String periodicity) {
        super(id, titulo, year, totalCopies, copiesAvailable, autor, editora, alunos, borrowed);
        this.issn = issn;
        this.editionNumber = editionNumber;
        this.periodicity = periodicity;
    }

    public Periodical(Long issn, Integer editionNumber, String periodicity) {
        this.issn = issn;
        this.editionNumber = editionNumber;
        this.periodicity = periodicity;
    }

    public Long getIssn() {
        return issn;
    }

    public void setIssn(Long issn) {
        this.issn = issn;
    }

    public Integer getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(Integer editionNumber) {
        this.editionNumber = editionNumber;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return super.toString() +
                "issn = " + issn +"\n"+
                "número da edição = " + editionNumber + "\n"+
                "periodicidade = " + periodicity + "\n";

    }
}