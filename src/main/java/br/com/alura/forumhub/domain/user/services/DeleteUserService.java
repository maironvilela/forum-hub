package br.com.alura.forumhub.domain.user.services;

import br.com.alura.forumhub.domain.user.services.validations.protocols.DeleteUserValidation;
import br.com.alura.forumhub.exceptions.shared.ResourceNotFoundException;
import br.com.alura.forumhub.infra.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteUserService {


    private final UserRepository userRepository;
    private final List<DeleteUserValidation> validations;

    public DeleteUserService(UserRepository userRepository, List<DeleteUserValidation> validations) {
        this.userRepository = userRepository;
        this.validations = validations;
    }

    public void execute(Long id){
        this.validations.forEach(v -> v.validation(id));
        this.userRepository.deleteById(id);
    }
}
