package br.com.alura.forumhub.domain.user.dtos;

import jakarta.validation.constraints.NotBlank;

public record AuthRequest(
        @NotBlank
        String email,
        @NotBlank
        String password) {
}
