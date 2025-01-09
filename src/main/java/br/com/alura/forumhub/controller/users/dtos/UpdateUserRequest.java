package br.com.alura.forumhub.controller.users.dtos;

import br.com.alura.forumhub.domain.profile.models.Profile;

import java.util.List;

public record UpdateUserRequest(
        Long id,
        String name,
        String email,
        String password,
        List<String> profiles
) {

}
