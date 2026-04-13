package com.entregas.nathy.ports.output;

import com.entregas.nathy.domain.entities.Pedido;

import java.util.Optional;

public interface ProcurarPorIdOutputPort {

    Optional<Pedido> procurarPorIdOutput (Long id);
}
