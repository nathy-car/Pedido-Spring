package com.entregas.nathy.adapter.output.persistence;

import com.entregas.nathy.adapter.output.data.pedido.PedidoTI;
import com.entregas.nathy.adapter.output.repositorio.pedido.PedidoRepositorio;
import com.entregas.nathy.domain.utils.Acompanhamento;
import com.entregas.nathy.domain.utils.Bebida;
import com.entregas.nathy.domain.utils.PratoPrincipal;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.cassandra.DataCassandraTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PedidoPersistenceTest {

    @Mock
    PedidoRepositorio pedidoRepositorio;



    @Test
    void cadastrar() {
        PedidoTI pedidoTI = new PedidoTI(
                null,
                "Giovanna",
                "Garcia",
                Acompanhamento.ARROZ,
                Bebida.AGUA,
                PratoPrincipal.FEIJOADA
        );

        pedidoRepositorio.save(pedidoTI);
        assertEquals("Giovanna", pedidoTI.getNome());
    }

    @Test
    void listarRepositorioVazio(){
        List<PedidoTI> pedidoTIList =  pedidoRepositorio.findAll();

        assertTrue(pedidoTIList.isEmpty());

    }

    @Test
    void listar() {
        PedidoTI pedidoTI = new PedidoTI(
                null,
                "Giovanna",
                "Garcia",
                Acompanhamento.ARROZ,
                Bebida.AGUA,
                PratoPrincipal.FEIJOADA
        );

        pedidoRepositorio.save(pedidoTI);
        List<PedidoTI> listaPedido = pedidoRepositorio.findAll();
        assertFalse(listaPedido.isEmpty());


    }

    @Test
    void deletar() {

    }

    @Test
    void atualizar() {
    }
}