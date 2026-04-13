package adapter.output.repositorio;

import com.entregas.nathy.NathyApplication;
import com.entregas.nathy.adapter.output.data.PedidoTI;
import com.entregas.nathy.adapter.output.repositorio.PedidoRepositorio;
import com.entregas.nathy.domain.utils.Acompanhamento;
import com.entregas.nathy.domain.utils.Bebida;
import com.entregas.nathy.domain.utils.PratoPrincipal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = NathyApplication.class)
class PedidoRepositorioTest {

    @Autowired
    PedidoRepositorio pedidoRepositorio;

    @Test
    void findByIdNaoEncontra() {
        Optional<PedidoTI> resultado = pedidoRepositorio.findById(999L); // id que não existe

        assertFalse(resultado.isPresent());
        assertTrue(resultado.isEmpty());

        // garante que não achou nada
    }

    @Test
    void findById() {
        PedidoTI pedidoTI = new PedidoTI(
                null,
                "Giovanna",
                "Garcia",
                Acompanhamento.ARROZ,
                Bebida.AGUA,
                PratoPrincipal.FEIJOADA
        );

        PedidoTI pedidoSalvo = pedidoRepositorio.save(pedidoTI);

        Optional<PedidoTI> resultado = pedidoRepositorio.findById(pedidoSalvo.getId());

        assertTrue(resultado.isPresent());
    }
}