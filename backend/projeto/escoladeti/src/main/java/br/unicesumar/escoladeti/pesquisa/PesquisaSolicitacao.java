package br.unicesumar.escoladeti.pesquisa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PesquisaSolicitacao {
    
    private String itemStatus;
    private Date dataChegadaInicio;
    private Date dataChegadaFim;
    private Long solicitacaoId;
    private Long ordemId;
    private String nomeMaterial;
    private String responsavel;
    private String revisor;

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        if (itemStatus != null) {
            this.itemStatus = itemStatus.toUpperCase();
        }
    }

    public Date getDataChegadaInicio() {
        return dataChegadaInicio;
    }

    public void setDataChegadaInicio(Date dataChegadaInicio) {
        if(dataChegadaFim != null && dataChegadaInicio.after(dataChegadaFim)){
            this.dataChegadaInicio = dataChegadaInicio;
        }else if(dataChegadaInicio != null){
            throw new RuntimeException("Data de Inicio não pode ser maior que Final"); 
        } 
        
    }

    public Date getDataChegadaFim() {
        return dataChegadaFim;
    }

    public void setDataChegadaFim(Date dataChegadaFim) {
        if (dataChegadaInicio != null && dataChegadaFim.before(dataChegadaInicio)) {
            this.dataChegadaFim = dataChegadaFim;
        }else if(dataChegadaFim != null){
            throw new RuntimeException("Data Final não pode ser Menos que da Inicio");
        }
    }

    public Long getSolicitacaoId() {
        return solicitacaoId;
    }

    public void setSolicitacaoId(Long solicitacaoId) {
        this.solicitacaoId = solicitacaoId;
    }

    public Long getOrdemId() {
        return ordemId;
    }

    public void setOrdemId(Long ordemId) {
        this.ordemId = ordemId;
    }

    public String getNomeMaterial() {
        return nomeMaterial;
    }

    public void setNomeMaterial(String nomeMaterial) {
        if (nomeMaterial != null) {
            this.nomeMaterial = nomeMaterial.toUpperCase();
        }
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        if(responsavel != null){
            this.responsavel = responsavel.toUpperCase();
        }    
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        if (revisor != null) {
            this.revisor = revisor.toUpperCase();
        }
    }
    
    
}
