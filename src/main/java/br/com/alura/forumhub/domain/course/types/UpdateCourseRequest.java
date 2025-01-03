package br.com.alura.forumhub.domain.course.types;

import jakarta.validation.constraints.NotBlank;

public record UpdateCourseRequest(
        @NotBlank(message = "Campo obrigatório")
        String name,
        Category category) {
}
