package com.entregas.nathy.adapter.exception.handler;

import com.entregas.nathy.adapter.exception.exception.PedidoNaoEncontradoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class PedidoExceptionHandlerTest {

    private PedidoExceptionHandler handler = new PedidoExceptionHandler();

    @Test
    @DisplayName("Deve retornar 404 quando pedido não for encontrado")
    void deveRetornarNotFound() {

        // GIVEN
        PedidoNaoEncontradoException exception =
                new PedidoNaoEncontradoException("Pedido não encontrado");

        // WHEN
        ResponseEntity<String> response =
                handler.handlePedidoNaoEncontrado(exception);

        // THEN
        assertEquals(404, response.getStatusCode().value());
        assertEquals("Pedido não encontrado", response.getBody());
    }
}