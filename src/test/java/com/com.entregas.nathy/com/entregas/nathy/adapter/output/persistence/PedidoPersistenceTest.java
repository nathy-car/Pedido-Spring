package com.entregas.nathy.adapter.output.persistence;

import com.entregas.nathy.adapter.output.data.PedidoTI;
import com.entregas.nathy.adapter.output.repositorio.PedidoRepositorio;
import com.entregas.nathy.domain.utils.Acompanhamento;
import com.entregas.nathy.domain.utils.Bebida;
import com.entregas.nathy.domain.utils.PratoPrincipal;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PedidoPersistenceTest {

    @Autowired
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