package com.entregas.nathy.adapter.output.repositorio.usuario;

import com.entregas.nathy.adapter.output.data.usuario.UsuarioTI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepositorio extends JpaRepository<UsuarioTI, String> {

    UserDetails findByLogin (String login);

}
