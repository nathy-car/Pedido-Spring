package com.entregas.nathy.ports.output;

import com.entregas.nathy.domain.entities.Pedido;

import java.util.Optional;
import java.util.UUID;

public interface ProcurarPorIdOutputPort {

    Optional<Pedido> procurarPorIdOutput (UUID id);
}
