package com.entregas.nathy.domain.usecase;

import com.entregas.nathy.domain.entities.Pedido;
import com.entregas.nathy.domain.entities.PedidoRequest;
import com.entregas.nathy.domain.entities.PedidoResponse;
import com.entregas.nathy.domain.entities.PedidoSemId;
import com.entregas.nathy.domain.utils.Acompanhamento;
import com.entregas.nathy.domain.utils.Bebida;
import com.entregas.nathy.domain.utils.PratoPrincipal;
import com.entregas.nathy.ports.output.AtualizarPedidoOutputPort;
import com.entregas.nathy.ports.output.CadastrarOutputPort;
import com.entregas.nathy.ports.output.DeletarOutputPort;
import com.entregas.nathy.ports.output.ListarOutPutPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PedidoUseCaseTest {

    @Mock
    ListarOutPutPort listarOutPutPort;

    @Mock
    CadastrarOutputPort cadastrarOutputPort;

    @Mock
    DeletarOutputPort deletarOutputPort;

    @Mock
    AtualizarPedidoOutputPort atualizarPedidoOutputPort;

    @InjectMocks
    PedidoUseCase pedidoUseCase;



    @Test
    @DisplayName("Deve listar os pedidos do repositório")
    void deveriaListarPedidos() {

        PedidoResponse listaMock = new PedidoResponse( null, Acompanhamento.ARROZ,
                        Bebida.AGUA,
                        PratoPrincipal.FEIJOADA
                );

        when(listarOutPutPort.listar()).thenReturn(List.of(listaMock));

        List<PedidoResponse> resultado = pedidoUseCase.listarPedidos();

        assertFalse(resultado.isEmpty());
        verify(listarOutPutPort).listar();
    }

    @Test
    @DisplayName("Deve retornar a lista vazia quando vazia")
    void deveriaRetornarListaVazia() {
        // cenário
        when(listarOutPutPort.listar()).thenReturn(Collections.emptyList());

        // execução
        List<PedidoResponse> resultado = pedidoUseCase.listarPedidos();

        // validação
        assertTrue(resultado.isEmpty());

        verify(listarOutPutPort).listar(); // verifica se chamou a porta
    }

    @Test
    @DisplayName("Deve cadastrar o pedido")
    void cadastrar() {

        PedidoRequest pedidoRequest = new PedidoRequest(
                "sdcwec",
                "sdccwse",
                Acompanhamento.ARROZ,
                Bebida.AGUA,
                PratoPrincipal.FEIJOADA
        );

        Pedido pedido = new Pedido(
                null,
                pedidoRequest.nome(),
                pedidoRequest.sobrenome(),
                pedidoRequest.acompanhamento(),
                pedidoRequest.bebida(),
                pedidoRequest.pratoPrincipal()
        );

        when(cadastrarOutputPort.cadastrar(any())).thenReturn(pedido);

        PedidoResponse resultado = pedidoUseCase.cadastrar(pedidoRequest);

        assertNotNull(resultado);
        assertEquals(pedidoRequest.acompanhamento(), resultado.acompanhamento());
        assertEquals(pedidoRequest.bebida(), resultado.bebida());
        assertEquals(pedidoRequest.pratoPrincipal(), resultado.pratoPrincipal());

        verify(cadastrarOutputPort).cadastrar(any());


    }

    @Test
    @DisplayName("Deletar um pedido por Id")
    void deletar() {
        Long id = 1L;

        pedidoUseCase.deletar(id);

        verify(deletarOutputPort).deletar(id);
    }

    @Test
    void atualizarPedido() {

        Long id = 1L;

        PedidoRequest pedidoRequest = new PedidoRequest(
                "sdcwec",
                "sdccwse",
                Acompanhamento.ARROZ,
                Bebida.AGUA,
                PratoPrincipal.FEIJOADA
        );

        Pedido pedido = new Pedido(id,
                pedidoRequest.nome(),
                pedidoRequest.sobrenome(),
                pedidoRequest.acompanhamento(),
                pedidoRequest.bebida(),
                pedidoRequest.pratoPrincipal());

        when(atualizarPedidoOutputPort.atualizar(anyLong(), any(PedidoSemId.class)))
                .thenReturn(pedido);
        // ✅ Act
        PedidoResponse response = pedidoUseCase.atualizarPedidoInputPort(id, pedidoRequest);

        // ✅ Verify
        verify(atualizarPedidoOutputPort)
                .atualizar(eq(id), any(PedidoSemId.class));

        // ✅ Assert do retorno
        assertEquals(id, response.id());
        assertEquals(pedidoRequest.acompanhamento(), response.acompanhamento());
        assertEquals(pedidoRequest.bebida(), response.bebida());
        assertEquals(pedidoRequest.pratoPrincipal(), response.pratoPrincipal());
    }
}