package com.entregas.nathy.domain.entities;

import com.entregas.nathy.domain.utils.Acompanhamento;
import com.entregas.nathy.domain.utils.Bebida;
import com.entregas.nathy.domain.utils.PratoPrincipal;

public record PedidoResponse(
        Long id,

        Acompanhamento acompanhamento,

        Bebida bebida,

        PratoPrincipal pratoPrincipal
) {
}
