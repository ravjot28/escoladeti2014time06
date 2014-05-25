package br.unicesumar.escoladeti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Pais extends Entidade {

    @Column(nullable = false)
    @NotEmpty
    private String nome;
    @Column(nullable = false)
    @NotEmpty
    private String sigla;
    @Column(nullable = false)
    private Integer codPais;

    public Pais() {

    }

    public Pais(Long id, String nome, String sigla, int codPais) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.codPais = codPais;
    }

    public Pais(String nome, String sigla, int codPais) {
        this.nome = nome;
        this.sigla = sigla;
        this.codPais = codPais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public int getCodPais() {
        return codPais;
    }

    public void setCodPais(int codPais) {
        this.codPais = codPais;
    }

}
