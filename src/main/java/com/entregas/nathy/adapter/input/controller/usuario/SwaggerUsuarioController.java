package com.entregas.nathy.adapter.input.controller.usuario;


import com.entregas.nathy.adapter.input.dto.login.AuthenticationDTO;
import com.entregas.nathy.adapter.input.dto.login.RegisterDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jdk.jfr.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "auth")
@Tag(name = "usuarios")
public interface SwaggerUsuarioController {

    @PostMapping(value = "/login")
    @Operation(description = "Logar o usuário já criado com o nome e a senha")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Retorna a lista de pedidos"),
            @ApiResponse(responseCode = "400", description = "Não existe lista")
    })
    ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO);

    @Operation(description = "Registrar um nome usuário com nome, senha e USER_ROLE")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Retorna a lista de pedidos"),
            @ApiResponse(responseCode = "400", description = "Não existe lista")
    })
    @PostMapping(value = "/registrar")
    ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO);
}
