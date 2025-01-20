package br.com.alura.forumhub.domain.user.services;

import br.com.alura.forumhub.domain.profile.dtos.Name;
import br.com.alura.forumhub.domain.user.dtos.CreateUserRequest;
import br.com.alura.forumhub.domain.user.model.User;
import br.com.alura.forumhub.domain.user.protocols.cryptography.Hasher;
import br.com.alura.forumhub.domain.user.services.validations.protocols.CreateUserValidation;
import br.com.alura.forumhub.infra.repositories.ProfileRepository;
import br.com.alura.forumhub.infra.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateUserService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final List<CreateUserValidation<CreateUserRequest>> validations;
    //private final PasswordEncoder passwordEncoder;
    private final Hasher hasher;


    public CreateUserService(UserRepository userRepository, ProfileRepository profileRepository, List<CreateUserValidation<CreateUserRequest>> validations, Hasher hasher){
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.validations = validations;
       // this.passwordEncoder = passwordEncoder;
        this.hasher = hasher;
    }

     public User execute(CreateUserRequest request){
        validateRequest(request);
        String hashedPassword = hashedPassword(request.password());
        var user = User.getInstance(request,hashedPassword);
        setProfiles(user, request);
        return this.userRepository.save(user);

    }

    private void validateRequest(CreateUserRequest request){
        validations.forEach(v -> v.validation(request));
    }

    private String hashedPassword(String textPassword){

        //return passwordEncoder.encode(textPassword);
        return hasher.hash(textPassword);
    }

    private void setProfiles(User user, CreateUserRequest request){
        request.profiles().forEach(p -> user.getProfiles().add(profileRepository.getByName(Name.valueOf(p))));
    }
}
