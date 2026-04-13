package com.entregas.nathy.ports.input;

import com.entregas.nathy.domain.entities.PedidoRequest;
import com.entregas.nathy.domain.entities.PedidoResponse;

public interface CadastrarInputPort {

    PedidoResponse cadastrar (PedidoRequest pedidoRequest);
}
