package br.com.alura.forumhub.domain.course.validations;

import br.com.alura.forumhub.domain.course.types.CreateCourseRequest;
import br.com.alura.forumhub.infra.exceptions.shared.ResourceAlreadyExistsException;
import br.com.alura.forumhub.infra.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueNameValidation implements CourseValidatorProtocol<CreateCourseRequest>{

    @Autowired
    private CourseRepository repository;
    @Override
    public void validation(CreateCourseRequest request) {

        var courseOptional = this.repository.findByName(request.name());

        if(courseOptional.isPresent()){
            throw new ResourceAlreadyExistsException("/courses");
        }

     }
}
