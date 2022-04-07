package com.microservices.grupo3.debito.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.grupo3.debito.model.Debito;
import com.microservices.grupo3.debito.model.SaldoDebitoResponse;
import com.microservices.grupo3.debito.service.DebitoService;


@RestController
@RequestMapping("/debito")
public class DebitoController {

    private final DebitoService debitoService;

    public DebitoController(DebitoService debitoService) {
        this.debitoService = debitoService;
    }

    @GetMapping(path = "/status_aplicacao")
    public String checarStatusAplicacao(){
        return "Aplicação de debito online";
    }

    @PostMapping
    public Debito createDebito(@RequestBody Debito debitoRequest) {
        return debitoService.criarDebito(debitoRequest);
    }

    //GET PARA CONSULTAR TODAS AS TRANSACOES POR TIPO CONTA
    @GetMapping(path = "/contas")
    public List<Debito> consultaTransacoesPorTipo(@RequestParam(value = "tipoConta", required = true) String tipoConta) {
        return debitoService.consultaTransacoesTipoConta(tipoConta);
    }

    //GET PARA CONSULTAR TODAS AS TRANSACOES DAS CONTAS	
    @GetMapping(path = "/listar/contas")
    public List<Debito> listarContas() {
        return debitoService.listarContas();
    }

    //GET PARA CONSULTAR TRANSACOES DE DEBITO POR CONTA CORRENTE
    @GetMapping("/extrato/contacorrente/{contaId}")
    public List<Debito> consultaExtratoContaCorrenteByContaId(@PathVariable Integer contaId) {
        return debitoService.consultaContaIdContaCorrente(contaId);
    }

    //GET PARA CONSULTAR TRANSACOES DE DEBITO POR CONTA INVESTIMENTO
    @GetMapping("/extrato/investimento/{contaId}")
    public List<Debito> consultaExtratoContaInvestimentoByContaId(@PathVariable Integer contaId) {
        return debitoService.consultaContaIdInvestimento(contaId);
    }

    //GET PARA CONSOLIDAR OS VALORES DE DEBITO EM UMA CONTA CORRENTE
    @GetMapping("/saldo/contacorrente/{contaId}")
    public SaldoDebitoResponse consultaSaldoConsolidadoContaCorrente(@PathVariable("contaId") Integer contaId) {
        SaldoDebitoResponse saldoDebitoResponse = new SaldoDebitoResponse(debitoService.consultaSaldoContaIdContaCorrente(contaId));
        return saldoDebitoResponse;
    }

    //GET PARA CONSOLIDAR OS VALORES DE DEBITO EM UMA CONTA INVESTIMENTO
    @GetMapping("/saldo/investimento/{contaId}")
    public SaldoDebitoResponse consultaSaldoConsolidadoContaInvestimento(@PathVariable("contaId") Integer contaId) {
        SaldoDebitoResponse saldoDebitoResponse = new SaldoDebitoResponse(debitoService.consultaSaldoContaIdContaInvestimento(contaId));
        return saldoDebitoResponse;
    }
}
