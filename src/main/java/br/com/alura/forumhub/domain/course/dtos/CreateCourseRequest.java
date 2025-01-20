package br.com.alura.forumhub.domain.course.dtos;

import jakarta.validation.constraints.NotBlank;

public record CreateCourseRequest(
        @NotBlank(message = "Campo obrigatório")
        String name,
        Category category) {
}
