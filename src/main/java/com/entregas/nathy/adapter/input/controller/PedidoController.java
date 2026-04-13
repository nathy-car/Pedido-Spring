package com.entregas.nathy.adapter.input.controller;

import com.entregas.nathy.adapter.input.mapper.PedidoInputMapper;
import com.entregas.nathy.adapter.input.dto.PedidoRequestDTO;
import com.entregas.nathy.adapter.input.dto.PedidoResponseDTO;
import com.entregas.nathy.domain.entities.PedidoResponse;
import com.entregas.nathy.ports.input.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoController implements SwaggerPedidoController{
    private final CadastrarInputPort cadastrarInputPort;
    private final ListarInputPort listarInputPort;
    private final DeletarInputPort deletarInputPort;
    private final AtualizarPedidoInputPort atualizarPedidoInputPort;
    private final ProcurarPorIdInputPort procurarPorIdInputPort;

    public PedidoController(ListarInputPort listarInputPort,
                            CadastrarInputPort cadastrarInputPort,
                            DeletarInputPort deletarInputPort,
                            AtualizarPedidoInputPort atualizarPedidoInputPort,
                            ProcurarPorIdInputPort procurarPorIdInputPort){
        this.listarInputPort = listarInputPort;
        this.cadastrarInputPort = cadastrarInputPort;
        this.deletarInputPort = deletarInputPort;
        this.atualizarPedidoInputPort = atualizarPedidoInputPort;
        this.procurarPorIdInputPort = procurarPorIdInputPort;
    }

    @Override
    public ResponseEntity<List<PedidoResponseDTO>> listarPedidos (){
        List<PedidoResponse> pedidoResponses = listarInputPort.listarPedidos();
        List<PedidoResponseDTO> pedidoResponseDTOS = PedidoInputMapper.INSTANCE.converterListaPedidoResponseParaPedidoResponseDTO(pedidoResponses);
        return ResponseEntity.ok(pedidoResponseDTOS);

    }

    @Override
    public ResponseEntity<PedidoResponseDTO> buscarPedidoPorId (@PathVariable Long id){
        PedidoResponse pedidoResponse = PedidoInputMapper.INSTANCE.converterPedidoPedidoResponse(procurarPorIdInputPort.procurarPorIdInput(id));
        PedidoResponseDTO pedidoResponseDTO = PedidoInputMapper.INSTANCE.converterPedidoResponseParaPedidoResponseDTO(pedidoResponse);
        return ResponseEntity.ok(pedidoResponseDTO);


    }

    @Override
    public ResponseEntity<PedidoResponseDTO> cadastrar (@RequestBody @Valid PedidoRequestDTO pedidoRequestDTO){
        PedidoResponse pedidoResponse = cadastrarInputPort.cadastrar(PedidoInputMapper.INSTANCE.converterPedidoRequestDTOParaPedidoRequest(pedidoRequestDTO));
        PedidoResponseDTO pedidoResponseDTO = PedidoInputMapper.INSTANCE.converterPedidoResponseParaPedidoResponseDTO(pedidoResponse);
        return ResponseEntity.ok(pedidoResponseDTO);


    }

    @Override
    public ResponseEntity<PedidoResponseDTO> alterarPedido (@PathVariable Long id,
                                                            @RequestBody @Valid PedidoRequestDTO pedidoRequestDTO){
        PedidoResponse pedidoResponse = atualizarPedidoInputPort.atualizarPedidoInputPort(id, PedidoInputMapper.INSTANCE.converterPedidoRequestDTOParaPedidoRequest(pedidoRequestDTO));
        PedidoResponseDTO pedidoResponseDTO = PedidoInputMapper.INSTANCE.converterPedidoResponseParaPedidoResponseDTO(pedidoResponse);
        return ResponseEntity.ok(pedidoResponseDTO);

    }

    @Override
    public ResponseEntity deletar(@PathVariable Long id){
        deletarInputPort.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
