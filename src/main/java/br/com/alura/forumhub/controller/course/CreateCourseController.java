package br.com.alura.forumhub.controller.course;

import br.com.alura.forumhub.controller.protocols.CreateResourceController;
import br.com.alura.forumhub.domain.course.models.Course;
import br.com.alura.forumhub.controller.course.dtos.CreateCourseRequest;
import br.com.alura.forumhub.controller.course.dtos.CreateCourseResponse;
import br.com.alura.forumhub.domain.course.validations.protocols.CourseValidatorProtocol;
import br.com.alura.forumhub.infra.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CreateCourseController implements CreateResourceController<CreateCourseRequest, CreateCourseResponse> {


    @Autowired
    private List<CourseValidatorProtocol<CreateCourseRequest>> validations;


    @Autowired
    private CourseRepository courseRepository;

    @PostMapping(name = "Cadastrar Curso")
    @Override
    public ResponseEntity<CreateCourseResponse> handle(CreateCourseRequest request, UriComponentsBuilder uriBuilder) {

        validations.forEach(v-> v.validation(request));

        var course = Course.created(request);


        var savedCourse = this.courseRepository.save(course);

        var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(savedCourse.getId()).toUri();


        var response = new CreateCourseResponse(savedCourse);


        return ResponseEntity.created(uri).body(response);
     }
}

