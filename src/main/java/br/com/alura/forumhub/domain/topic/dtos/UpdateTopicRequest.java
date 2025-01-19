package br.com.alura.forumhub.domain.topic.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateTopicRequest (

        @NotBlank(message = "The Title field is required")
        String title,
        @NotBlank(message = "The Message field is required")
        String message,
        @NotBlank(message = "The Message AuthorId field is required")
        String authorId,
        @NotBlank(message = "The Message CourseId field is required")
        String courseId
){

}
