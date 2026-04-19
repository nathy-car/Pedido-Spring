package com.entregas.nathy.adapter.output.persistence;

import com.entregas.nathy.adapter.exception.exception.PedidoNaoEncontradoException;
import com.entregas.nathy.adapter.output.data.pedido.PedidoTI;
import com.entregas.nathy.adapter.output.mapper.PedidoOutputMapper;
import com.entregas.nathy.adapter.output.repositorio.pedido.PedidoRepositorio;
import com.entregas.nathy.domain.entities.Pedido;
import com.entregas.nathy.domain.entities.PedidoResponse;
import com.entregas.nathy.domain.entities.PedidoSemId;
import com.entregas.nathy.ports.output.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PedidoPersistence implements ListarOutPutPort,
        CadastrarOutputPort, DeletarOutputPort,
        AtualizarPedidoOutputPort,
        ProcurarPorIdOutputPort {

    private final PedidoRepositorio pedidoRepositorio;

    public PedidoPersistence(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    @Override
    public Pedido cadastrar(PedidoSemId pedidoSemId) {
        PedidoTI pedidoTI = PedidoOutputMapper.INSTANCE.pedidoSemIdParaPedidoTI(pedidoSemId);
        PedidoTI pedidoTIsalvo = pedidoRepositorio.save(pedidoTI);
        return PedidoOutputMapper.INSTANCE.pedidoTIParaPedido(pedidoTIsalvo);

    }

    @Override
    public List<PedidoResponse> listar() {
        List<PedidoTI> encontrar = pedidoRepositorio.findAll();
        return PedidoOutputMapper.INSTANCE.listaPedidoTIParaPedidoResponse(encontrar);
    }

    @Override
    public void deletar(Long id) {
        Optional<PedidoTI> pedidoTI = pedidoRepositorio.findById(id);
        if (pedidoTI.isEmpty()){
            throw new PedidoNaoEncontradoException("Pedido não encontrado");
        }
        pedidoRepositorio.deleteById(id);
    }

    @Override
    public Pedido atualizar(Long id, PedidoSemId pedidoSemId) {
        Optional<PedidoTI> pedidoTI = pedidoRepositorio.findById(id);
        PedidoTI pedido = PedidoOutputMapper.INSTANCE.pedidoSemIdParaPedidoTI(pedidoSemId);
        pedido.setId(id);
        pedidoRepositorio.save(pedido);
        return PedidoOutputMapper.INSTANCE.pedidoTIParaPedido(pedido);
    }

    @Override
    public Optional<Pedido> procurarPorIdOutput(Long id) {
        Optional<PedidoTI> pedidoTI = pedidoRepositorio.findById(id);
        return pedidoTI.map(m -> new Pedido(
                m.getId(),
                m.getNome(),
                m.getSobrenome(),
                m.getAcompanhamento(),
                m.getBebida(),
                m.getPratoPrincipal()
        ));
    }
}
