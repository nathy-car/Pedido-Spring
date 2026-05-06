package com.entregas.nathy.ports.output;

import com.entregas.nathy.domain.entities.PedidoResponse;

import java.util.List;

public interface ListarOutPutPort {

    List<PedidoResponse> listar();
}
