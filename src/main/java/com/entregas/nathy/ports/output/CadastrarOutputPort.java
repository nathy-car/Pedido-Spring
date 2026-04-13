package com.entregas.nathy.ports.output;

import com.entregas.nathy.domain.entities.Pedido;
import com.entregas.nathy.domain.entities.PedidoSemId;

public interface CadastrarOutputPort {

    Pedido cadastrar (PedidoSemId pedidoSemId);
}
