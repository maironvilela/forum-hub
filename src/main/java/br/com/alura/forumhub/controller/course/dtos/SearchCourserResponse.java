package br.com.alura.forumhub.controller.course.dtos;

import br.com.alura.forumhub.domain.course.models.Course;

public record SearchCourserResponse(Long id, String name, String category) {

    public SearchCourserResponse(Long id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public SearchCourserResponse(Course course){
        this(course.getId(), course.getName(), course.getCategory().toString());
    }
}
