package com.entregas.nathy.adapter.input.dto.pedido;

import com.entregas.nathy.domain.utils.Acompanhamento;
import com.entregas.nathy.domain.utils.Bebida;
import com.entregas.nathy.domain.utils.PratoPrincipal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PedidoRequestDTO(

        @NotBlank(message = "O nome do cliente é obrigatório")
        @org.springframework.data.cassandra.core.mapping.Column
        String nome,

        @NotBlank(message = "O sobrenome do cliente é obrigatório")
        @org.springframework.data.cassandra.core.mapping.Column        String sobrenome,

        @NotNull(message = "Acompanhamentos disponíveis: ARROZ,BATATA_FRITA, ONION_RINGS, SALADA,")
        @org.springframework.data.cassandra.core.mapping.Column        Acompanhamento acompanhamento,

        @NotNull(message = "Bebidas disponíveis: REFRIGERANTE, AGUA, SUCO, VINHO do cliente é obrigatório")
        @org.springframework.data.cassandra.core.mapping.Column        Bebida bebida,

        @NotNull(message = "PARMEGIANA, LASANHA, FEIJOADA, RISOTOS")
        @org.springframework.data.cassandra.core.mapping.Column
        PratoPrincipal pratoPrincipal

) {


}
