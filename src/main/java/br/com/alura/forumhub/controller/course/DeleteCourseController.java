package br.com.alura.forumhub.controller.course;

import br.com.alura.forumhub.controller.protocols.DeleteResourceController;
import br.com.alura.forumhub.domain.course.services.DeleteCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class DeleteCourseController implements DeleteResourceController {

    @Autowired
    private DeleteCourseService deleteCourseService;

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> handle(Long id) {
        this.deleteCourseService.execute(id);
        return ResponseEntity.noContent().build();
    }
}
