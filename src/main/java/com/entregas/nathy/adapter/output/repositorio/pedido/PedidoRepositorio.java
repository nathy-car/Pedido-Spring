package com.entregas.nathy.adapter.output.repositorio.pedido;

import com.entregas.nathy.adapter.output.data.pedido.PedidoTI;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PedidoRepositorio extends CassandraRepository<PedidoTI, UUID> {

    @Override
    Optional<PedidoTI> findById(UUID login);
}
