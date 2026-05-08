package com.entregas.nathy.ports.input;

import com.entregas.nathy.domain.entities.Pedido;

import java.util.UUID;

public interface ProcurarPorIdInputPort {


    Pedido procurarPorIdInput(String id);
}
