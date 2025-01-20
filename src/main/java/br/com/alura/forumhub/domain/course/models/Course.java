package br.com.alura.forumhub.domain.course.models;

import br.com.alura.forumhub.domain.course.dtos.Category;
import br.com.alura.forumhub.domain.course.dtos.CreateCourseRequest;
import br.com.alura.forumhub.domain.course.dtos.UpdateCourseRequest;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


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
