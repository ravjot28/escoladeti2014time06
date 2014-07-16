package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.unicesumar.escoladeti.enums.StatusItem;
import br.unicesumar.escoladeti.enums.TraducaoMaterial;

@Entity
public class SolicitacaoItem extends Entidade{
	private static final long serialVersionUID = 1L;
	
	private String outro;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TraducaoMaterial traducaoMaterial;
	
	@ManyToOne
	@JoinColumn(name="id_material")
	private Livro livro;	

	@ManyToOne
	@JoinColumn(name="id_solicitacao")
	@JsonIgnore
	private Solicitacao solicitacao;
	
	@Enumerated(EnumType.STRING)
	private StatusItem status;
	
	public SolicitacaoItem() {
	}
	
	public Solicitacao getSolicitacao() {
		return solicitacao;
	}
	
	public TraducaoMaterial getTraducaoMaterial() {
		return traducaoMaterial;
	}
	
	public void setTraducaoMaterial(TraducaoMaterial traducaoMaterial) {
		this.traducaoMaterial = traducaoMaterial;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public String getOutro() {
		return outro;
	}
	
	public void setOutro(String outro) {
		this.outro = outro;
	}

	public void setStatus(StatusItem status) {
		this.status = status;
	}
	
	public StatusItem getStatus() {
		return status;
	}
}
