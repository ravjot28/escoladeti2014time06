package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.pesquisa.PesquisaSolicitacao;
import br.unicesumar.escoladeti.service.AcompanhamentoSolicitacaoService;
import br.unicesumar.escoladeti.view.ViewAcompanhamentoSolicitacao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/acompanhamentosolicitacoes")
public class AcompanhamentoSolicitacaoController {

    @Autowired
    private AcompanhamentoSolicitacaoService acompanhamentosolicitacaoService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ViewAcompanhamentoSolicitacao> listarItens( //        @RequestParam(required = false, value = "status") String status,
            //        @RequestParam(required = false, value = "dataInicio") Date dataInicio,
            //        @RequestParam(required = false, value = "dataFim") Date dataFim,
            //        @RequestParam(required = false, value = "solicitacaoId") Long solicitacaoId,
            //        @RequestParam(required = false, value = "ordemId") Long ordemId,
            //        @RequestParam(required = false, value = "material") String material,
            //        @RequestParam(required = false, value = "responsavel") String responsavel,
            //        @RequestParam(required = false, value = "revisor") String revisor
            ) {
        PesquisaSolicitacao ps = new PesquisaSolicitacao();
//            ps.setStatus(status);
//            ps.setDataInicio(dataInicio);
//            ps.setDataFim(dataFim);
//            ps.setSolicitacaoId(solicitacaoId);
//            ps.setOrdemId(ordemId);
//            ps.setMaterial(material);
//            ps.setResponsavel(responsavel);
//            ps.setRevisor(revisor);
        return acompanhamentosolicitacaoService.listarItens();
    }

    @RequestMapping(value="/filtros",method = RequestMethod.GET)
    @ResponseBody
    public List<ViewAcompanhamentoSolicitacao> listarItensFiltrados(
            @RequestParam(value = "dataChegadaInicio", required = false) String dataChegadaInicio,
            @RequestParam(value = "dataChegadaFim", required = false) String dataChegadaFim, 
            @RequestParam(value = "status",required = false) String status) 
    {
        PesquisaSolicitacao ps = new PesquisaSolicitacao();
        ps.setDataChegadaInicio(dataChegadaInicio);
        ps.setDataChegadaFim(dataChegadaFim);
        ps.setItemStatus(status);
        return acompanhamentosolicitacaoService.listarItensFiltrados(ps);
    }
}
