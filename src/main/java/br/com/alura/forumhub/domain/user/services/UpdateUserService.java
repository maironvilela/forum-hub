package br.com.alura.forumhub.domain.user.services;


import br.com.alura.forumhub.domain.profile.dtos.Name;
import br.com.alura.forumhub.domain.user.dtos.UpdateUserRequest;
import br.com.alura.forumhub.domain.profile.models.Profile;
import br.com.alura.forumhub.domain.user.model.User;
import br.com.alura.forumhub.domain.user.services.validations.protocols.UpdateUserValidation;
import br.com.alura.forumhub.infra.repositories.ProfileRepository;
import br.com.alura.forumhub.infra.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UpdateUserService {

    private final List<UpdateUserValidation<UpdateUserRequest>> validations;
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    public UpdateUserService(List<UpdateUserValidation<UpdateUserRequest>> validations, UserRepository userRepository, ProfileRepository profileRepository) {
        this.validations = validations;
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;

    }

    @Transactional
    public User execute(UpdateUserRequest request, Long id){
        this.validations.forEach(v -> v.validation(request));

        var user =  this.userRepository.findById(id).get();

        var profiles = loadProfiles(request);
         user.update(request, profiles);
       return user;
    }

    private List<Profile> loadProfiles( UpdateUserRequest request){
        List<Profile> profiles = new ArrayList<>();

        if(!request.profiles().isEmpty()){
              request.profiles().forEach(p -> profiles.add(this.profileRepository.getByName(Name.valueOf(p))));
        }
         return profiles;
    }
}
