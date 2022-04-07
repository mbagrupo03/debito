package com.microservices.grupo3.debito.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.microservices.grupo3.debito.exceptions.ContaIdNotFoundException;
import com.microservices.grupo3.debito.exceptions.TipoContaBadRequestException;
import com.microservices.grupo3.debito.exceptions.TipoContaNotFoundException;
import com.microservices.grupo3.debito.model.Debito;
import com.microservices.grupo3.debito.model.TipoConta;
import com.microservices.grupo3.debito.repository.DebitoRepository;

@Component
public class DebitoService {

    private DebitoRepository repository;
    public DebitoService(DebitoRepository repository) {
        this.repository = repository;
    }

    public Debito criarDebito(Debito debito) {

        if(!debito.getTipoConta().equals(TipoConta.contacorrente.toString()) && !debito.getTipoConta().equals(TipoConta.investimento.toString())) {
            throw new TipoContaBadRequestException("Tipo de conta iválido, por favor digitar contacorrente ou investimento");
        }
        return repository.save(debito);
    }

    public List<Debito> listarContas() {return repository.listarContas();}

    public List<Debito> consultaTransacoesTipoConta(String tipoConta) {

        if(!tipoConta.equals(TipoConta.contacorrente.toString()) && !tipoConta.equals(TipoConta.investimento.toString())) {
            throw new TipoContaNotFoundException("Tipo de conta incorreta, por favor pesquisar por tipo contacorrente ou investimento");
        }

        var contas = repository.findByTipoConta(tipoConta);
        return contas;
    }

    public List<Debito> consultaContaIdContaCorrente(Integer contaId) {

        var listDebito = repository.findByContaIdAndTipoConta(contaId, "contacorrente");

        if (listDebito.isEmpty()) {
            throw new ContaIdNotFoundException("Não encontrada conta id: " + contaId);
        }
        return listDebito;
    }

    public List<Debito> consultaContaIdInvestimento(Integer contaId) {

        var listDebito = repository.findByContaIdAndTipoConta(contaId, "investimento");

        if(listDebito.isEmpty()) {
            throw new ContaIdNotFoundException("Não encontrada conta id: " + contaId);
        }
        return listDebito;
    }

    public Double consultaSaldoContaIdContaCorrente(Integer contaId) {
        try{
            return  repository.findBySaldoDebitoPorTipoConta(contaId, "contacorrente");
        } catch (RuntimeException runtimeException) {
            throw new ContaIdNotFoundException("Não encontrada conta id: " + contaId);
        }
    }

    public Double consultaSaldoContaIdContaInvestimento(Integer contaId) {
        try{
            return  repository.findBySaldoDebitoPorTipoConta(contaId, "investimento");
        }catch (RuntimeException runtimeException) {
            throw new ContaIdNotFoundException("Não encontrada conta id: " + contaId);
        }
    }
}
