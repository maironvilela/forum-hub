package br.com.alura.forumhub.domain.user.dtos;

public record AuthResponse(String token) {

    public AuthResponse(String token) {
        this.token = token;
    }
}
