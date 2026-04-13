package com.entregas.nathy.config;

import com.entregas.nathy.adapter.output.data.PedidoTI;
import com.entregas.nathy.adapter.output.repositorio.PedidoRepositorio;
import com.entregas.nathy.domain.utils.Acompanhamento;
import com.entregas.nathy.domain.utils.Bebida;
import com.entregas.nathy.domain.utils.PratoPrincipal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class PedidoMockado implements CommandLineRunner{

    private final PedidoRepositorio pedidoRepositorio;

    public PedidoMockado(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    @Override
    public void run(String... args) throws Exception {
        PedidoTI pedidoTI = new PedidoTI(
                null,
                "Giovanna",
                "Garcia",
                Acompanhamento.ARROZ,
                Bebida.AGUA,
                PratoPrincipal.FEIJOADA
        );

        pedidoRepositorio.save(pedidoTI);

    }
}
