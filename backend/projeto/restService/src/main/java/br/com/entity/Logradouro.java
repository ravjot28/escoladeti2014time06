package br.com.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
class Logradouro extends Entidade{
    private String tipoDoEndereco;
    private String nome;
    
    @ManyToOne
    private FaixaDeCep faixaDeCep;
    
    @OneToMany(mappedBy = "logradouro")
    @NotNull
    private List<Endereco> enderecos;

    public String getTipoDoEndereco() {
        return tipoDoEndereco;
    }

    public void setTipoDoEndereco(String tipoDoEndereco) {
        this.tipoDoEndereco = tipoDoEndereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public FaixaDeCep getFaixaDeCep() {
        return faixaDeCep;
    }

    public void setFaixaDeCep(FaixaDeCep faixaDeCep) {
        this.faixaDeCep = faixaDeCep;
    }
}