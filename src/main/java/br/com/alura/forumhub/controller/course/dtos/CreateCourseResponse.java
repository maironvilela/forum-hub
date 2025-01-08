package br.com.alura.forumhub.controller.course.dtos;

import br.com.alura.forumhub.domain.course.models.Course;

public record CreateCourseResponse(Long id, String name, Category category) {

    public CreateCourseResponse(Course course){
         this(course.getId(), course.getName(), course.getCategory());
    }
}
