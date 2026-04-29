package com.entregas.nathy.ports.input;

import com.entregas.nathy.domain.entities.PedidoRequest;
import com.entregas.nathy.domain.entities.PedidoResponse;

import java.util.UUID;

public interface AtualizarPedidoInputPort {

    PedidoResponse atualizarPedidoInputPort(Long id, PedidoRequest pedidoRequest);
}
