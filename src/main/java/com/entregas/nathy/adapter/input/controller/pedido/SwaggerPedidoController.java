package com.entregas.nathy.adapter.input.controller.pedido;

import com.entregas.nathy.adapter.exception.handler.ErrorResponse;
import com.entregas.nathy.adapter.input.dto.pedido.PedidoRequestDTO;
import com.entregas.nathy.adapter.input.dto.pedido.PedidoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/pedido")
@Tag(name = "Pedido")
public interface SwaggerPedidoController {

    @GetMapping(value = "/listar-pedido")
    @Operation(description = "Lista os pedidos já salvos no repositório") //Não aparece na resposta
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Retorna a lista de pedidos"),
            @ApiResponse(responseCode = "400", description = "Não existe lista")
    })
        //Aparece no Swagger
    ResponseEntity<List<PedidoResponseDTO>> listarPedidos();

    @Operation(description = "Busca o pedido pelo ID informado no parâmetro")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Retorna o pedido"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")})
    @GetMapping(value = "/buscar-pedido-id/{id}")
    ResponseEntity<PedidoResponseDTO> buscarPedidoPorId(@PathVariable String id);

    @Operation(description = "Cadastra um novo pedido")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Retorna o pedido"),
            @ApiResponse(responseCode = "400", description = "Json inválido")})
    @PostMapping(value = "/publicar-pedido")
    ResponseEntity<PedidoResponseDTO> cadastrar(@RequestBody @Valid PedidoRequestDTO pedidoRequestDTO);

    @Operation(description = "Altera o campo de um pedido já criado")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Retorna o pedido alterado"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")})
    @PutMapping(value = "alterar-pedido/{id}")
    ResponseEntity<PedidoResponseDTO> alterarPedido(@PathVariable String id,
                                                    @RequestBody @Valid PedidoRequestDTO pedidoRequestDTO);

    @Operation(description = "Deleta o pedido pelo ID informado no repositório")
    @ApiResponses(value = {@ApiResponse(responseCode = "202", description = "Deleta o pedido e não aparece body"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    ))})
    @DeleteMapping(value = "deletar-pedido/{id}")
    ResponseEntity deletar(@PathVariable String id);

}
