package br.com.alura.forumhub.domain.topic.dtos;

import br.com.alura.forumhub.domain.course.models.Course;
import br.com.alura.forumhub.domain.user.model.User;
import jakarta.validation.constraints.NotBlank;

public record CreateTopicRequest (
        @NotBlank(message = "The Title field is required")
        String title,
        @NotBlank(message = "The Message field is required")
        String message,
        @NotBlank(message = "The Message AuthorId field is required")
        String authorId,
        @NotBlank(message = "The Message CourseId field is required")
        String courseId
) {
}
