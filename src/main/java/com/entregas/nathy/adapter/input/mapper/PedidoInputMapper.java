package com.entregas.nathy.adapter.input.mapper;


import com.entregas.nathy.adapter.input.dto.pedido.PedidoRequestDTO;
import com.entregas.nathy.adapter.input.dto.pedido.PedidoResponseDTO;
import com.entregas.nathy.domain.entities.Pedido;
import com.entregas.nathy.domain.entities.PedidoRequest;
import com.entregas.nathy.domain.entities.PedidoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoInputMapper {

    PedidoInputMapper INSTANCE = Mappers.getMapper(PedidoInputMapper.class);

    PedidoRequest converterPedidoRequestDTOParaPedidoRequest (PedidoRequestDTO pedidoRequestDTO);
    PedidoResponseDTO converterPedidoResponseParaPedidoResponseDTO(PedidoResponse pedidoResponse);
    List<PedidoResponseDTO> converterListaPedidoResponseParaPedidoResponseDTO(List<PedidoResponse> pedidoResponse);
    PedidoResponse  converterPedidoPedidoResponse(Pedido pedido);
}
