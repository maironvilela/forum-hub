package br.com.alura.forumhub.domain.course.validations;

import br.com.alura.forumhub.domain.course.dtos.UpdateCourseRequest;
import br.com.alura.forumhub.domain.course.validations.protocols.DeleteCourseValidateProtocol;
import br.com.alura.forumhub.domain.course.validations.protocols.UpdateCourseValidateProtocol;
import br.com.alura.forumhub.exceptions.shared.ResourceNotFoundException;
import br.com.alura.forumhub.infra.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IsCourseExistsValidation implements DeleteCourseValidateProtocol<Long>, UpdateCourseValidateProtocol<UpdateCourseRequest> {

    @Autowired
    private CourseRepository repository;

    @Override
    public void valid(Long id) {
        isCourseExists(id);
    }

    @Override
    public void valid(UpdateCourseRequest updateCourseValidateProtocol, Long id) {
        isCourseExists(id);
    }

    private void isCourseExists(Long id){
        var optionalCourse = this.repository.findById(id);

        if(optionalCourse.isEmpty()){
            throw new ResourceNotFoundException("Curso com ID" +id+" não existe", "/courses");
        }

    }


}
