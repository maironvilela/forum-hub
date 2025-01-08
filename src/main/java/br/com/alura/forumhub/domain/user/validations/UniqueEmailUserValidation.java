package br.com.alura.forumhub.domain.user.validations;

import br.com.alura.forumhub.controller.users.dtos.CreateUserRequest;
import br.com.alura.forumhub.domain.user.validations.protocols.CreateUserValidation;
import br.com.alura.forumhub.exceptions.users.EmailAlreadyExistsException;
import br.com.alura.forumhub.infra.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailUserValidation implements CreateUserValidation<CreateUserRequest> {

    private final UserRepository userRepository;

    public UniqueEmailUserValidation(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public void validation(CreateUserRequest request) {
         var userOptional = this.userRepository.findByEmail(request.email());


        if(userOptional.isPresent()) {
            throw new EmailAlreadyExistsException("Email ja cadastrado", "/users");
        }


     }
}
