package com.entregas.nathy.ports.input;

import com.entregas.nathy.domain.entities.Pedido;
import com.entregas.nathy.domain.entities.PedidoResponse;

import java.util.List;

public interface ListarInputPort {

    List<PedidoResponse> listarPedidos();
}
