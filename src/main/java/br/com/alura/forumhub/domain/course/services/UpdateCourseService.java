package br.com.alura.forumhub.domain.course.services;

import br.com.alura.forumhub.domain.course.models.Course;
import br.com.alura.forumhub.domain.course.types.UpdateCourseRequest;
import br.com.alura.forumhub.infra.exceptions.shared.ResourceNotFoundException;
import br.com.alura.forumhub.infra.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCourseService {

    @Autowired
    private CourseRepository repository;

    public Course execute(UpdateCourseRequest request, Long courseId){

        var optionalCourse = this.repository.findById(courseId);

        if(optionalCourse.isEmpty()){
            throw new ResourceNotFoundException("Recurso com ID" +courseId+" não existe");
        }

        var course = optionalCourse.get();
        course.update(request);

        return course;
    }
}
