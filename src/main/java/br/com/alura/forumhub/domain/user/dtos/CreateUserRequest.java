package br.com.alura.forumhub.domain.user.dtos;

import br.com.alura.forumhub.domain.profile.models.Profile;

import java.util.ArrayList;
import java.util.List;

public record CreateUserRequest(
        String name,
        String email,
        String password,
        List<String> profiles
) {
}
