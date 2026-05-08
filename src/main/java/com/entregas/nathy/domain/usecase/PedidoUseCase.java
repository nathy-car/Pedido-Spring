package com.entregas.nathy.domain.usecase;

import com.entregas.nathy.domain.entities.Pedido;
import com.entregas.nathy.domain.entities.PedidoResponse;
import com.entregas.nathy.domain.entities.PedidoSemId;
import com.entregas.nathy.domain.entities.PedidoRequest;
import com.entregas.nathy.ports.input.*;
import com.entregas.nathy.ports.output.*;

import java.util.List;

public class PedidoUseCase implements ListarInputPort, CadastrarInputPort,
        DeletarInputPort,
        AtualizarPedidoInputPort,
        ProcurarPorIdInputPort {

    private final CadastrarOutputPort cadastrarOutputPort;
    private final ListarOutPutPort listarOutPutPort;
    private final DeletarOutputPort deletarOutputPort;
    private final AtualizarPedidoOutputPort atualizarPedidoOutputPort;
    private final ProcurarPorIdOutputPort procurarPorIdOutputPort;

    public PedidoUseCase(ListarOutPutPort listarOutPutPort,
                         CadastrarOutputPort cadastrarOutputPort,
                         DeletarOutputPort deletarOutputPort,
                         AtualizarPedidoOutputPort atualizarPedidoOutputPort,
                         ProcurarPorIdOutputPort procurarPorIdOutputPort) {
        this.listarOutPutPort = listarOutPutPort;
        this.cadastrarOutputPort = cadastrarOutputPort;
        this.deletarOutputPort = deletarOutputPort;
        this.atualizarPedidoOutputPort = atualizarPedidoOutputPort;
        this.procurarPorIdOutputPort = procurarPorIdOutputPort;
    }


    @Override
    public List<PedidoResponse> listarPedidos() {
        return listarOutPutPort.listar();
    }

    private PedidoResponse pedidoParaPedidoResponse (Pedido pedido){
        PedidoResponse pedidoResponse = new PedidoResponse(
                pedido.getId(),
                pedido.getAcompanhamento(),
                pedido.getBebida(),
                pedido.getPratoPrincipal()
        );

        return pedidoResponse;
    }

    @Override
    public PedidoResponse cadastrar(PedidoRequest pedidoRequest) {
        PedidoSemId pedidoSemId = new PedidoSemId(
                pedidoRequest.nome(),
                pedidoRequest.sobrenome(),
                pedidoRequest.acompanhamento(),
                pedidoRequest.bebida(),
                pedidoRequest.pratoPrincipal()
        );

        Pedido pedido = cadastrarOutputPort.cadastrar(pedidoSemId);
        PedidoResponse pedidoResponse = pedidoParaPedidoResponse(pedido);

         return pedidoResponse;

    }

    @Override
    public void deletar(String id) {

        deletarOutputPort.deletar(id);

    }


    @Override
    public PedidoResponse atualizarPedidoInputPort(String id, PedidoRequest pedidoRequest) {
        PedidoSemId pedidoSemId = new PedidoSemId(
                pedidoRequest.nome(),
                pedidoRequest.sobrenome(),
                pedidoRequest.acompanhamento(),
                pedidoRequest.bebida(),
                pedidoRequest.pratoPrincipal()
        );

        PedidoResponse pedidoResponse = new PedidoResponse(
                id,
                pedidoRequest.acompanhamento(),
                pedidoRequest.bebida(),
                pedidoRequest.pratoPrincipal()
        );


        atualizarPedidoOutputPort.atualizar(id,pedidoSemId);

        return pedidoResponse;
    }

    @Override
    public Pedido procurarPorIdInput(String id) {
        return procurarPorIdOutputPort.procurarPorIdOutput(id).orElseThrow();
    }
}
