package com.entregas.nathy.adapter.output.data;

import com.entregas.nathy.domain.utils.Acompanhamento;
import com.entregas.nathy.domain.utils.Bebida;
import com.entregas.nathy.domain.utils.PratoPrincipal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PedidoTI {

    @Column(name = "id", length = 100)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(name = "user_name", length = 100, nullable = false)
    private String nome;

    @NotBlank
    @Column(name = "user_lastname", length = 100, nullable = false)
    private String sobrenome;

    @NotNull
    @Column(name = "side_dish", length = 100, nullable = false)
    private Acompanhamento acompanhamento;

    @NotNull
    @Column(name = "drinks", length = 100, nullable = false)
    private Bebida bebida;

    @NotNull
    @Column(name = "main_course", length = 100, nullable = false)
    private PratoPrincipal pratoPrincipal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Acompanhamento getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(Acompanhamento acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public PratoPrincipal getPratoPrincipal() {
        return pratoPrincipal;
    }

    public void setPratoPrincipal(PratoPrincipal pratoPrincipal) {
        this.pratoPrincipal = pratoPrincipal;
    }
}
