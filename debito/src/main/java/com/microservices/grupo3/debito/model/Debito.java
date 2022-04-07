package com.microservices.grupo3.debito.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "debito")
public class Debito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transacao")
    private Integer idTransacao;

    @Column(name = "conta_id")
    private Integer contaId;

    @Column(name = "valor_debito")
    private double valorDebito;

    @Column(name = "cliente_id")
    private Integer clienteId;

    @Column(name = "tipo_conta")
    private String tipoConta;
    
    
    
    

	public Debito() {
		super();
	}
	
	

	public Debito(Integer idTransacao, Integer contaId, double valorDebito, Integer clienteId, String tipoConta) {
		super();
		this.idTransacao = idTransacao;
		this.contaId = contaId;
		this.valorDebito = valorDebito;
		this.clienteId = clienteId;
		this.tipoConta = tipoConta;
	}



	public Integer getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(Integer idTransacao) {
		this.idTransacao = idTransacao;
	}

	public Integer getContaId() {
		return contaId;
	}

	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}

	public double getValorDebito() {
		return valorDebito;
	}

	public void setValorDebito(double valorDebito) {
		this.valorDebito = valorDebito;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
    
    
    

}
