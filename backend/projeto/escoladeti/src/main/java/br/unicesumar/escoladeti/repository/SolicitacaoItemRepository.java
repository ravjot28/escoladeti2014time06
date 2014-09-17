package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.dto.AcompanhamentoDTO;
import br.unicesumar.escoladeti.entity.SolicitacaoItem;
import br.unicesumar.escoladeti.pesquisa.PesquisaSolicitacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SolicitacaoItemRepository extends JpaRepository<SolicitacaoItem, Long>{

}


/*
@Repository
public class SolicitacaoItemRepository{
    
    public List<AcompanhamentoDTO>listarItens(PesquisaSolicitacao pesquisa, DataSource dataSource) {
        
        List<AcompanhamentoDTO>itens = new ArrayList<>();
         
        String consultaBase = "select  so.datachegada dataChegada, so.id solicitacaoId, pe.nome responsavel, pf.sobrenome sobrenomeResponsavel, si.traducaomaterial traducao, op.id ordemId,si.status, li.nome nomeMaterial from solicitacaoitem  si "
                + " join solicitacao so on(so.id = si.id_solicitacao) "
                + " join pessoafisica pf on(pf.id = so.id_responsavel) " 
                + " join pessoa pe on(pf.id = pe.id) "
                + " left join ordemproducao op on(op.solicitacaoitem_id = si.id) "
                + " left join material ma on(ma.id = si.id_material) "
                + " left join livro li on(li.id = si.id_material) "
                + " where 1=1 ";
        if (pesquisa.getStatus() != null ) {
            consultaBase += " and si.status =" + "'" +pesquisa.getStatus()+"'";
        }
        if(pesquisa.getDataInicio() != null && pesquisa.getDataFim() != null){

            consultaBase += " and so.datachegada between " + "'"+ pesquisa.getDataInicio()+"'";
            consultaBase += "and" + "'"+pesquisa.getDataFim()+"'";
        }
        if(pesquisa.getDataInicio() != null){
            consultaBase += " and so.datachegada >=" + "'"+ pesquisa.getDataInicio()+"'";
        }
        if(pesquisa.getDataFim()!= null){
            consultaBase += " and so.datachegada <=" + "'"+ pesquisa.getDataFim()+"'";
        }
        if(pesquisa.getSolicitacaoId() != null){
            consultaBase += " and so.id =" + "'"+pesquisa.getSolicitacaoId()+"'";
        }
        if(pesquisa.getOrdemId() != null){
            consultaBase += " and op.id =" + "'"+pesquisa.getOrdemId()+"'";
        }
        if(pesquisa.getMaterial() != null){
            consultaBase += " and li.nome =" + "'"+pesquisa.getMaterial()+"'";
        }
        if(pesquisa.getResponsavel() != null){
            consultaBase += " and pe.nome =" + "'"+pesquisa.getResponsavel()+"'";
        }
//        verificar de onde busca o revisor
//        if(pesquisa.getRevisor()!= null){
//            consultaBase += " and pe.nome =" +pesquisa.getRevisor();
//        }
        try {
            Connection conexao = dataSource.getConnection();
            PreparedStatement preparedStatement = conexao.prepareStatement(consultaBase);
            ResultSet resultado = preparedStatement.executeQuery();
            while (resultado.next()) {
                AcompanhamentoDTO acompanhamentoDTO = new AcompanhamentoDTO();
                acompanhamentoDTO.setStatus(resultado.getString("status"));
                acompanhamentoDTO.setSolicitacaoId(resultado.getLong("solicitacaoId"));
                acompanhamentoDTO.setDataChegada(resultado.getDate("dataChegada"));
                acompanhamentoDTO.setTraducao(resultado.getString("traducao"));
                acompanhamentoDTO.setResponsavel(resultado.getString("responsavel"));
                acompanhamentoDTO.setSobrenomeResponsavel(resultado.getString("sobrenomeResponsavel"));
                acompanhamentoDTO.setOrdemId(resultado.getLong("ordemId"));
                acompanhamentoDTO.setMaterial(resultado.getString("nomeMaterial"));
//                acompanhamentoDTO.setDataEnvio(resultado.getDate("dataEnvio")); NAO EXISTE AINDA
                
                itens.add(acompanhamentoDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("erro ao realizar pesquisa");
        }
        return itens;
    }
}
*/