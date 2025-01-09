package br.com.alura.forumhub.domain.user.services.validations;

import br.com.alura.forumhub.controller.users.dtos.UpdateUserRequest;
import br.com.alura.forumhub.domain.user.services.validations.protocols.UpdateUserValidation;
import br.com.alura.forumhub.exceptions.users.EmailAlreadyExistsException;
import br.com.alura.forumhub.infra.repositories.UserRepository;
import org.springframework.stereotype.Component;


@Component
public class ExistsUserWithEmailAndIdValidation implements UpdateUserValidation<UpdateUserRequest> {

    private final UserRepository userRepository;

    public ExistsUserWithEmailAndIdValidation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validation(UpdateUserRequest request) {
       var isUserExists = this.userRepository.existsByEmailAndIdNot(request.email(),request.id());

       if(isUserExists){
           throw new EmailAlreadyExistsException("E-mail ja cadastrado","/user/"+request.id());
       }

    }
}
