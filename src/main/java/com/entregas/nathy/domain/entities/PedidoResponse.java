package com.entregas.nathy.domain.entities;

import com.entregas.nathy.domain.utils.Acompanhamento;
import com.entregas.nathy.domain.utils.Bebida;
import com.entregas.nathy.domain.utils.PratoPrincipal;

import java.util.UUID;

public record PedidoResponse(
        String id,

        Acompanhamento acompanhamento,

        Bebida bebida,

        PratoPrincipal pratoPrincipal
) {
}
