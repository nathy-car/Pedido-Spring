package com.entregas.nathy.ports.output;

import com.entregas.nathy.domain.entities.Pedido;
import com.entregas.nathy.domain.entities.PedidoSemId;

import java.util.UUID;

public interface AtualizarPedidoOutputPort {

    Pedido atualizar(Long id, PedidoSemId pedidoSemId);
}
