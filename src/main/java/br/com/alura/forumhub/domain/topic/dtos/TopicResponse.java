package br.com.alura.forumhub.domain.topic.dtos;

import br.com.alura.forumhub.domain.course.models.Course;
import br.com.alura.forumhub.domain.topic.models.Topic;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record TopicResponse(
        Long id,
        String title,
        String message,
        String author,
        String course,
        LocalDateTime createdAt

) {

        public TopicResponse(Long id, String title, String message, String author, String course, LocalDateTime createdAt) {
                this.id = id;
                this.title = title;
                this.message = message;
                this.author = author;
                this.course = course;
                this.createdAt = createdAt;
        }

        public TopicResponse(Topic topic){
                this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getAuthor().getName(), topic.getCourse().getName(), topic.getCreatedAt());
        }
}
