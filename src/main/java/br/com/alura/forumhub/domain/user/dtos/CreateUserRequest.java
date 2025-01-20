package br.com.alura.forumhub.domain.user.dtos;

import java.util.List;

public record CreateUserRequest(
        String name,
        String email,
        String password,
        List<String> profiles
) {
}
