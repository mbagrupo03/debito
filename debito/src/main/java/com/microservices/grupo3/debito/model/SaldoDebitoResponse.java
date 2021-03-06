package com.microservices.grupo3.debito.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaldoDebitoResponse {

    private double saldoDebito;

    @JsonCreator
    public SaldoDebitoResponse(@JsonProperty("saldo_debito") double saldoDebito){
        this.saldoDebito = saldoDebito;
    }

    public double getSaldoDebito() {return saldoDebito;}

    public void setSaldoDebito(double saldoDebito) {this.saldoDebito = saldoDebito;}
}
