package br.com.alura.forumhub.domain.course.services;

import br.com.alura.forumhub.domain.course.validations.protocols.DeleteCourseValidateProtocol;
import br.com.alura.forumhub.infra.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteCourseService {

    @Autowired
    private List<DeleteCourseValidateProtocol<Long>> validations;

    @Autowired
    private CourseRepository repository;

    public void execute(Long id){
        validations.forEach(v -> v.valid(id));
        this.repository.deleteById(id);
    }
}
