package br.com.alura.forumhub.domain.topic.dtos;

import br.com.alura.forumhub.domain.course.models.Course;
import br.com.alura.forumhub.domain.user.model.User;
import jakarta.validation.constraints.NotBlank;

import java.awt.*;

public record UpdateTopic(
         String title,
         String message,
         User author,
         Course course
) {
}
