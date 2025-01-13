package br.com.alura.forumhub.controller.users.dtos;

import jakarta.validation.constraints.NotBlank;

public record AuthRequest(
        @NotBlank
        String email,
        @NotBlank
        String password) {
}
