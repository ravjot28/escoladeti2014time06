package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.pesquisa.PesquisaSolicitacao;
import br.unicesumar.escoladeti.repository.AcompanhamentoSolicitacaoRepository;
import br.unicesumar.escoladeti.view.ViewAcompanhamentoSolicitacao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcompanhamentoSolicitacaoService {
    
    @Autowired
    private AcompanhamentoSolicitacaoRepository acompanhamentoSolicitacaoRepository;
    
    public List<ViewAcompanhamentoSolicitacao> listarItens() {
        return acompanhamentoSolicitacaoRepository.findAll();
    }	

    public List<ViewAcompanhamentoSolicitacao> listarItensFiltrados(PesquisaSolicitacao ps) {
        return this.acompanhamentoSolicitacaoRepository.findByDataChegadaBetweenAndStatusContainingAndMaterialContainingAndResponsavelContainingAndRevisorContainingAndTraducaoMaterialContaining(
        		//ps.getSolicitacaoId(),
                ps.getDataChegadaInicio(),
        		ps.getDataChegadaFim(),
        		ps.getStatus(),
        		ps.getMaterial(),
        		ps.getResponsavel(),
        		ps.getTraducaoMaterial()
        		);
    }
}
