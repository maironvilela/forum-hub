package br.com.alura.forumhub.domain.user.services.validations;

import br.com.alura.forumhub.controller.users.dtos.UpdateUserRequest;
import br.com.alura.forumhub.domain.user.services.validations.protocols.UpdateUserValidation;
import br.com.alura.forumhub.exceptions.shared.ResourceNotFoundException;
import br.com.alura.forumhub.infra.repositories.UserRepository;
import org.springframework.stereotype.Component;


@Component
public class UserExistsValidation implements UpdateUserValidation<UpdateUserRequest> {

    private final UserRepository userRepository;

    public UserExistsValidation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validation(UpdateUserRequest request) {
        System.out.println("#### UserExistsValidation ####");
        var isUserExists = this.userRepository.existsById(request.id());
        if(!isUserExists){
            throw new ResourceNotFoundException(request.name() + " nao encontrado", "/users/"+request.id());
        }
    }
}
