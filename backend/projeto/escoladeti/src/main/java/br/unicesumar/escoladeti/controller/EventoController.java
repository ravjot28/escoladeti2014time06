package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.comando.ComandoSalvarEvento;
import br.unicesumar.escoladeti.entity.Evento;
import br.unicesumar.escoladeti.service.EventoService;
import br.unicesumar.escoladeti.util.data.DateUtil;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/eventoSource")
public class EventoController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Autowired
    private EventoService eventoService;

    @RequestMapping(value = "/evento", method = RequestMethod.POST)
    @ResponseBody
    public Evento salvar(@RequestBody ComandoSalvarEvento comando) throws Exception {
        System.out.println("comand: total size --> " + comando.getPeriodos().size());
        System.out.println(comando.toString());
        return this.eventoService.persistirEvento(comando,null);
    }

    @RequestMapping(value = "/evento/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Evento getById(@PathVariable Long id) {
        return eventoService.getById(id);
    }

    @RequestMapping(value = "/listartodoseventos", method = RequestMethod.GET)
    @ResponseBody
    public List<Evento> listarTodosEventos() {
        return eventoService.listarTodosEventos();
    }
    
    @RequestMapping(value = "/evento", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Evento> getTodos() {
        return eventoService.getTodos(1);
    }
    @RequestMapping(value = "/evento/{status}", params = {"q"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Evento> getEventoPorTitulo(@RequestParam String q, @PathVariable String status) {
        return eventoService.getEventoPorTitulo(q, status);
    }
    
    @RequestMapping(value = "/listartodosabertos/pag/{pagina}", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Evento> getTodosAbertos(@PathVariable Integer pagina) {
        return eventoService.getTodosAbertos(pagina);
    }
    
    @RequestMapping(value = "/listartodosfechados/pag/{pagina}", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Evento> getTodosFechados(@PathVariable Integer pagina) {
        return eventoService.getTodosFechados(pagina);
    }

    @RequestMapping(value = {"/listar/pag/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Evento> listarEvento(@PathVariable Integer pagina) {
        return eventoService.getTodos(pagina);
    }

    @RequestMapping(value = "/evento", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody Evento evento) throws Exception {
        eventoService.deletar(evento);
        return "deleted";
    }

    @RequestMapping(value = "/evento", method = RequestMethod.PUT)
    @ResponseBody
    public Evento editar(@RequestBody Evento evento) {
        Evento eventoEditado = this.eventoService.getById(evento.getId());
        System.out.println("Evento " + evento.getId());
        return eventoService.salvar(eventoEditado);
    }

}
