package com.entregas.nathy.ports.input;

import com.entregas.nathy.domain.entities.Pedido;

public interface ProcurarPorIdInputPort {

    Pedido procurarPorIdInput (Long id);
}
