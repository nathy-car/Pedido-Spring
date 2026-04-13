package com.entregas.nathy.adapter.exception.handler;


import com.entregas.nathy.adapter.exception.exception.PedidoNaoEncontradoException;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.LocalDateTime;

@Schema(name = "ErrorResponse")
@RestControllerAdvice
public class PedidoExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PedidoNaoEncontradoException.class)
    public ProblemDetail handlePedidoNaoEncontrado(PedidoNaoEncontradoException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("Não encontrado");
        problemDetail.setType(URI.create("/errors/pedido-nao-encontrado"));
        problemDetail.setDetail(ex.getMessage());;

        return problemDetail;
    }
}