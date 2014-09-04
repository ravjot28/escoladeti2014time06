package br.unicesumar.escoladeti.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class UnidadeFederativa extends Entidade{
    @Column(nullable=false)
    @NotEmpty
    private String nome;
    @Column(nullable = false)
    @NotEmpty
    private String sigla;
    
    @ManyToOne
    @JoinColumn(name="paisId",referencedColumnName = "id")
    private Pais pais;
    
    public UnidadeFederativa() {
    }    

//    public UnidadeFederativa(String nome, String sigla, Pais pais, Long id) {
//            this.id = id;
//            this.nome = nome;
//            this.sigla = sigla;
//            this.pais = pais;
//    }
//
//    public UnidadeFederativa(String nome, String sigla, Pais pais) {
//            this.nome = nome;
//            this.sigla = sigla;
//            this.pais = pais;
//    }

    public String getNome() {
            return nome;
    }
    public void setNome(String nome) {
            this.nome = nome.toUpperCase();
    }
    public String getSigla() {
            return sigla;
    }
    public void setSigla(String sigla) {
            this.sigla = sigla.toUpperCase();
    }
    public Pais getPais() {
            return pais;
    }
    public void setPais(Pais pais) {
            this.pais = pais;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.sigla);
        //hash = 67 * hash + Objects.hashCode(this.pais);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UnidadeFederativa other = (UnidadeFederativa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sigla, other.sigla)) {
            return false;
        }
//        if (!Objects.equals(this.pais, other.pais)) {
//            return false;
//        }
        return true;
    }
}
