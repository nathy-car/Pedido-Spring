package com.entregas.nathy.adapter.input.dto.login;

import com.entregas.nathy.domain.utils.UserRoles;

public record RegisterDTO(String login, String senha, UserRoles role) {
}
