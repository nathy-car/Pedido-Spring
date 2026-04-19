package com.entregas.nathy.config;

import com.entregas.nathy.adapter.output.persistence.PedidoPersistence;
import com.entregas.nathy.adapter.output.repositorio.pedido.PedidoRepositorio;
import com.entregas.nathy.domain.usecase.PedidoUseCase;
import com.entregas.nathy.ports.output.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfiguration {

    @Bean
    PedidoPersistence pedidoPersistence(PedidoRepositorio pedidoRepositorio){
        return new PedidoPersistence(pedidoRepositorio);
    }

    @Bean
    public PedidoUseCase pedidoUseCase(ListarOutPutPort listarOutPutPort,
                                       CadastrarOutputPort cadastrarOutputPort,
                                       DeletarOutputPort deletarOutputPort,
                                       AtualizarPedidoOutputPort atualizarPedidoOutputPort,
                                       ProcurarPorIdOutputPort procurarPorIdOutputPort){
       return new PedidoUseCase(listarOutPutPort, cadastrarOutputPort, deletarOutputPort, atualizarPedidoOutputPort, procurarPorIdOutputPort);
   }



}
