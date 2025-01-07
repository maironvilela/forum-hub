package br.com.alura.forumhub.domain.user.services;

import br.com.alura.forumhub.domain.profile.dtos.Name;
import br.com.alura.forumhub.domain.profile.models.Profile;
import br.com.alura.forumhub.domain.user.dtos.CreateUserRequest;
import br.com.alura.forumhub.domain.user.dtos.CreateUserResponse;
import br.com.alura.forumhub.domain.user.model.User;
import br.com.alura.forumhub.domain.user.validations.protocols.CreateUserValidation;
import br.com.alura.forumhub.infra.repositories.ProfileRepository;
import br.com.alura.forumhub.infra.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateUserService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final List<CreateUserValidation<CreateUserRequest>> validations;

    public CreateUserService(UserRepository userRepository, ProfileRepository profileRepository, List<CreateUserValidation<CreateUserRequest>> validations){
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.validations = validations;

    }

     public void execute(CreateUserRequest request){

        validations.forEach(v -> v.validation(request));

        var user = User.getInstance(request);

        request.profiles().forEach(p -> user.getProfiles().add(profileRepository.getByName(Name.valueOf(p))));

         System.out.println(user.toString());

        this.userRepository.save(user);

    }
}
