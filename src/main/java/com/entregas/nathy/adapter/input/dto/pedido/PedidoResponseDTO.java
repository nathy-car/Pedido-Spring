package com.entregas.nathy.adapter.input.dto.pedido;


import com.entregas.nathy.domain.utils.Acompanhamento;
import com.entregas.nathy.domain.utils.Bebida;
import com.entregas.nathy.domain.utils.PratoPrincipal;


public record PedidoResponseDTO(

        Long id,

        Acompanhamento acompanhamento,

        Bebida bebida,

        PratoPrincipal pratoPrincipal
) {


}
