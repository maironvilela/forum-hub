package br.com.alura.forumhub.controller.course;

import br.com.alura.forumhub.controller.protocols.UpdateResourceController;
import br.com.alura.forumhub.domain.course.services.UpdateCourseService;
import br.com.alura.forumhub.domain.course.types.UpdateCourseRequest;
import br.com.alura.forumhub.domain.course.types.UpdateCourseResponse;
import br.com.alura.forumhub.infra.repositories.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("cursos")
public class UpdateCourseController implements UpdateResourceController<UpdateCourseRequest, UpdateCourseResponse> {

    @Autowired
    private UpdateCourseService service;

    @PutMapping("/{id}")
    @Transactional
    @Override
    public ResponseEntity<UpdateCourseResponse> handle(@PathVariable Long id, UpdateCourseRequest request) {

        var course = this.service.execute(request, id );

        return ResponseEntity.ok().body(new UpdateCourseResponse(course));
    }
}
