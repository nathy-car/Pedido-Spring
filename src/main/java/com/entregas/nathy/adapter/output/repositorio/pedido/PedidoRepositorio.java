package com.entregas.nathy.adapter.output.repositorio.pedido;

import com.entregas.nathy.adapter.output.data.pedido.PedidoTI;
import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PedidoRepositorio extends JpaRepository<PedidoTI, Long> {

    @Override
    Optional<PedidoTI> findById(Long login);
}
