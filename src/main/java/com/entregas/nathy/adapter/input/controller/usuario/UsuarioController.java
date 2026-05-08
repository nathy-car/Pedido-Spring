package com.entregas.nathy.adapter.input.controller.usuario;

import com.entregas.nathy.adapter.infraSecurity.TokenService;
import com.entregas.nathy.adapter.input.dto.login.AuthenticationDTO;
import com.entregas.nathy.adapter.input.dto.login.LoginResponseDTO;
import com.entregas.nathy.adapter.input.dto.login.RegisterDTO;
import com.entregas.nathy.adapter.output.data.usuario.UsuarioTI;
import com.entregas.nathy.adapter.output.repositorio.usuario.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController implements SwaggerUsuarioController{

    @Autowired
    TokenService tokenService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioRepositorio usuarioRepositorio;


    @Override
    public ResponseEntity login(AuthenticationDTO authenticationDTO) {
        {
            var senhaUsuario = new UsernamePasswordAuthenticationToken(authenticationDTO.login(), authenticationDTO.senha());

            var auth = this.authenticationManager.authenticate(senhaUsuario);

            var token = tokenService.gerarToken((UsuarioTI) auth.getPrincipal());

            return ResponseEntity.ok().body(new LoginResponseDTO(token));
        }
    }

    @Override
    public ResponseEntity register(RegisterDTO registerDTO) {
        {
            if(this.usuarioRepositorio.findByLogin(registerDTO.login()) != null) return ResponseEntity.badRequest().build();

            String senhaEncriptada = new BCryptPasswordEncoder().encode(registerDTO.senha());
            UsuarioTI usuarioTI = new UsuarioTI(registerDTO.login(), senhaEncriptada, registerDTO.role());

            this.usuarioRepositorio.save(usuarioTI);

            return ResponseEntity.ok().build();
        }
    }
}
