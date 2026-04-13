package com.entregas.nathy.domain.entities;

import com.entregas.nathy.domain.utils.Acompanhamento;
import com.entregas.nathy.domain.utils.Bebida;
import com.entregas.nathy.domain.utils.PratoPrincipal;

public class PedidoSemId {

    private String nome;

    private String sobrenome;

    private Acompanhamento acompanhamento;

    private Bebida bebida;

    private PratoPrincipal pratoPrincipal;


    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Acompanhamento getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(Acompanhamento acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public PratoPrincipal getPratoPrincipal() {
        return pratoPrincipal;
    }

    public void setPratoPrincipal(PratoPrincipal pratoPrincipal) {
        this.pratoPrincipal = pratoPrincipal;
    }

    public PedidoSemId(String nome, String sobrenome, Acompanhamento acompanhamento, Bebida bebida, PratoPrincipal pratoPrincipal) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.acompanhamento = acompanhamento;
        this.bebida = bebida;
        this.pratoPrincipal = pratoPrincipal;
    }
}
