package br.com.alura.forumhub.domain.topic.models;

import br.com.alura.forumhub.domain.course.models.Course;
import br.com.alura.forumhub.domain.topic.dtos.UpdateTopic;
import br.com.alura.forumhub.domain.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
 @Table(name = "topics")
@Entity(name = "Topic")

public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "courser_id")
    private Course course;


    public Topic(String title, String message,  Course course,  User author) {
        this.title = title;
        this.message = message;
        this.course = course;
        this.author = author;
    }

    public void update(String title, String message,  Course course,  User author){
        this.title = title.trim().isEmpty()?this.title: title;
        this.message = message.trim().isEmpty()?this.message: message;
        this.course = course == null?this.course: course;
        this.author = author == null?this.author: author;
    }
}
