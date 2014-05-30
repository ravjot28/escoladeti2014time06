package br.unicesumar.escoladeti.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Solicitacao extends Entidade {

    private static final long serialVersionUID = 1L;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_solicitante", referencedColumnName = "id")
    private Pessoa solicitante;

    @NotEmpty
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "solicitacao_alunos")
    private List<PessoaFisica> alunos;

    private String nre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_responsavel")
    private PessoaFisica responsavel;

    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_solicitacao")
    private List<SolicitacaoItem> itensSolicitacao;

    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataChegada;

    public Solicitacao() {
    }

    public Solicitacao(PessoaFisica responsavel, Date dataChegada) {
        this.responsavel = responsavel;
        this.dataChegada = dataChegada;
    }

    public void setNre(String nre) {
        this.nre = nre;
    }

    public String getNre() {
        return nre;
    }
}
