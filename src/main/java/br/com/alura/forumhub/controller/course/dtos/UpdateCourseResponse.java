package br.com.alura.forumhub.controller.course.dtos;

import br.com.alura.forumhub.domain.course.models.Course;

public record UpdateCourseResponse(Long id, String name, Category category) {

    public UpdateCourseResponse(Course course){
        this(course.getId(), course.getName(), course.getCategory());
    }
}
