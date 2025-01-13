package br.com.alura.forumhub.controller.users.dtos;

public record AuthResponse(String token) {

    public AuthResponse(String token) {
        this.token = token;
    }
}
