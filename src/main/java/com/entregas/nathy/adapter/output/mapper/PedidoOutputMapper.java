package com.entregas.nathy.adapter.output.mapper;

import com.entregas.nathy.adapter.output.data.PedidoTI;
import com.entregas.nathy.domain.entities.Pedido;
import com.entregas.nathy.domain.entities.PedidoResponse;
import com.entregas.nathy.domain.entities.PedidoSemId;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoOutputMapper {

    PedidoOutputMapper INSTANCE = Mappers.getMapper(PedidoOutputMapper.class);

    PedidoTI pedidoSemIdParaPedidoTI(PedidoSemId pedidoSemId);
    Pedido  pedidoTIParaPedido(PedidoTI pedidoTI);
    List<PedidoResponse> listaPedidoTIParaPedidoResponse(List<PedidoTI> pedidoTIList);
    PedidoTI pedidoParaPedidoTI(Pedido pedido);

}
