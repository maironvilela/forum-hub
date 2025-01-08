package br.com.alura.forumhub.domain.course.services;

import br.com.alura.forumhub.domain.course.models.Course;
import br.com.alura.forumhub.controller.course.dtos.UpdateCourseRequest;
import br.com.alura.forumhub.domain.course.validations.protocols.UpdateCourseValidateProtocol;
import br.com.alura.forumhub.infra.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateCourseService {

    @Autowired
    private CourseRepository repository;

    @Autowired
    private List<UpdateCourseValidateProtocol<UpdateCourseRequest>> validations;

    public Course execute(UpdateCourseRequest request, Long id){
        this.validations.forEach(v -> v.valid(request, id));

        var course = this.repository.getReferenceById(id);
        course.update(request);
        return course;
    }
}
