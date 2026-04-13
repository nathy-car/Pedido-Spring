package com.entregas.nathy.domain.entities;

import com.entregas.nathy.domain.utils.Acompanhamento;
import com.entregas.nathy.domain.utils.Bebida;
import com.entregas.nathy.domain.utils.PratoPrincipal;

public record PedidoRequest(
         String nome,

         String sobrenome,

         Acompanhamento acompanhamento,

         Bebida bebida,

         PratoPrincipal pratoPrincipal
) {
}
