package br.com.alura.forumhub.controller.users.dtos;

import java.util.List;

public record CreateUserRequest(
        String name,
        String email,
        String password,
        List<String> profiles
) {
}
