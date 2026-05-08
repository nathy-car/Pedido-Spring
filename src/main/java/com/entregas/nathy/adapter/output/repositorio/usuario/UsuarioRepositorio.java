package com.entregas.nathy.adapter.output.repositorio.usuario;

import com.entregas.nathy.adapter.output.data.usuario.UsuarioTI;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepositorio extends MongoRepository<UsuarioTI, String> {

    UserDetails findByLogin (String login);

}
