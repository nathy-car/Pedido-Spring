package com.entregas.nathy.adapter.input.dto.pedido;

import com.entregas.nathy.domain.utils.Acompanhamento;
import com.entregas.nathy.domain.utils.Bebida;
import com.entregas.nathy.domain.utils.PratoPrincipal;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PedidoRequestDTO(

        @NotBlank(message = "O nome do cliente é obrigatório")
        @Column(name = "user_name", length = 100, nullable = false)
        String nome,

        @NotBlank(message = "O sobrenome do cliente é obrigatório")
        @Column(name = "user_lastname", length = 100, nullable = false)
        String sobrenome,

        @NotNull(message = "Acompanhamentos disponíveis: ARROZ,BATATA_FRITA, ONION_RINGS, SALADA,")
        @Column(name = "side_dish", length = 100, nullable = false)
        Acompanhamento acompanhamento,

        @NotNull(message = "Bebidas disponíveis: REFRIGERANTE, AGUA, SUCO, VINHO do cliente é obrigatório")
        @Column(name = "drinks", length = 100, nullable = false)
        Bebida bebida,

        @NotNull(message = "PARMEGIANA, LASANHA, FEIJOADA, RISOTOS")
        @Column(name = "main_course", length = 100, nullable = false)
        PratoPrincipal pratoPrincipal

) {


}
