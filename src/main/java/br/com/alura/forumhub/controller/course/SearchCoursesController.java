package br.com.alura.forumhub.controller.course;

import br.com.alura.forumhub.controller.protocols.SearchResourceController;
import br.com.alura.forumhub.domain.course.dtos.SearchCourserResponse;
import br.com.alura.forumhub.domain.course.dtos.SearchCoursesRequest;
import br.com.alura.forumhub.infra.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/courses")
public class SearchCoursesController implements SearchResourceController<SearchCoursesRequest, SearchCourserResponse> {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    @Override
    public ResponseEntity<Page<SearchCourserResponse>> handle(@PageableDefault(size = 10, page = 0, sort = {"name"}) Pageable pageable, SearchCoursesRequest filter) {
        var courses = this.courseRepository.findAll(pageable);
        var response = courses.map(SearchCourserResponse :: new);
        return ResponseEntity.ok(response);
    }
}
