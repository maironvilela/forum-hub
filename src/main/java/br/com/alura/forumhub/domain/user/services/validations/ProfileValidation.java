package br.com.alura.forumhub.domain.user.services.validations;

import br.com.alura.forumhub.domain.profile.dtos.Name;
import br.com.alura.forumhub.domain.user.dtos.CreateUserRequest;
import br.com.alura.forumhub.domain.user.services.validations.protocols.CreateUserValidation;
import br.com.alura.forumhub.exceptions.users.ProfileValidationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ProfileValidation implements CreateUserValidation<CreateUserRequest> {
    @Override
    public void validation(CreateUserRequest request) {
        String acceptedValues = Arrays.toString(Name.values());

        var textProfiles = request.profiles();

        textProfiles.forEach((profile) ->{
            if(!validProfile(profile.toUpperCase())){
                throw new ProfileValidationException("Perfil "+ profile+ " invalido. Perfís válidos: "+acceptedValues, "/users");
            }
        });
    }

    private boolean validProfile(String profile) {
        return Arrays.stream(Name.values())
                .anyMatch(name -> name.name().equals(profile));
    }
}
