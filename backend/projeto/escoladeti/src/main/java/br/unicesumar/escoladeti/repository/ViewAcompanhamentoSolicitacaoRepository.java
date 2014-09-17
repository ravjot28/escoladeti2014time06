package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.view.ViewAcompanhamentoSolicitacao;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ViewAcompanhamentoSolicitacaoRepository extends JpaRepository<ViewAcompanhamentoSolicitacao, Long>{     

    @Query(value = "select a "
            + "from viewAcompanhamentoSolicitacao a "
            + "where a.datachegada between nullif(?1,a.datachegada) and nullif(?2,a.datachegada) "
            + "and a.itemStatus = ?3", nativeQuery = false)
    public List<ViewAcompanhamentoSolicitacao> findByStartDataChegadaBetweenAndItem(Date dataChegadaInicio, Date dataChegadaFim, String status);
       
}
