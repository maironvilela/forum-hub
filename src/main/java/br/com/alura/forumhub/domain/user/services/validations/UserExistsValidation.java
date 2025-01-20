package br.com.alura.forumhub.domain.user.services.validations;

import br.com.alura.forumhub.domain.user.dtos.UpdateUserRequest;
import br.com.alura.forumhub.domain.user.services.validations.protocols.DeleteUserValidation;
import br.com.alura.forumhub.domain.user.services.validations.protocols.UpdateUserValidation;
import br.com.alura.forumhub.exceptions.shared.ResourceNotFoundException;
import br.com.alura.forumhub.infra.repositories.UserRepository;
import org.springframework.stereotype.Component;


@Component
public class UserExistsValidation implements UpdateUserValidation<UpdateUserRequest>, DeleteUserValidation {

    private final UserRepository userRepository;

    public UserExistsValidation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validation(UpdateUserRequest request) {
        this.findUserById(request.id());
    }

    @Override
    public void validation(Long id) {
        this.findUserById(id);
    }

    private void findUserById(Long id){
        var isUserExists = this.userRepository.existsById(id);
        if(!isUserExists){
            throw new ResourceNotFoundException("Recurso nao encontrado", "/users/"+id);
        }

    }
}
