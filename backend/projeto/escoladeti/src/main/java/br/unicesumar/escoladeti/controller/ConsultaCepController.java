package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.BuscaCep;
import br.unicesumar.escoladeti.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/cepSource")
public class ConsultaCepController {

    @Autowired
    private CepService cepService;

    @RequestMapping(value = "/cep/{cep}", method = RequestMethod.GET)
    @ResponseBody
    public BuscaCep getByCep(@PathVariable String cep) {
  
        return cepService.findByCepContainingOrderByCepAsc(cep);
    }

}
