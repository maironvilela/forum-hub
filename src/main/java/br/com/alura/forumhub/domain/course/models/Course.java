package br.com.alura.forumhub.domain.course.models;

import br.com.alura.forumhub.controller.course.dtos.Category;
import br.com.alura.forumhub.controller.course.dtos.CreateCourseRequest;
import br.com.alura.forumhub.controller.course.dtos.UpdateCourseRequest;
import br.com.alura.forumhub.domain.topic.models.Topic;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity(name = "Course")
@Table(name = "courses")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;



    public Course(String name, Category category){
        this.name = name;
        this.category = category;
    }

    public static Course created(CreateCourseRequest request){
        return new Course(request.name(), request.category());
    }

    public void update(UpdateCourseRequest request){
        this.name = request.name() == null || request.name().trim().isEmpty()?this.name: request.name();
        this.category = request.category() == null  ?this.category: request.category();
    }
}
