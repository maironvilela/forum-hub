package br.com.alura.forumhub.controller.profiles;


import br.com.alura.forumhub.controller.protocols.CreateResourceController;
import br.com.alura.forumhub.domain.profile.DTOs.CreateProfileRequest;
import br.com.alura.forumhub.domain.profile.DTOs.CreateProfileResponse;
import br.com.alura.forumhub.domain.profile.models.Profile;
import br.com.alura.forumhub.infra.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/perfis")
public class CreateProfileController implements CreateResourceController<CreateProfileRequest, CreateProfileResponse> {


    @Autowired
    private ProfileRepository repository;

    @PostMapping
    @Override
    public ResponseEntity<CreateProfileResponse> handle(CreateProfileRequest request, UriComponentsBuilder uriBuilder) {

        var savedProfile = this.repository.save(Profile.getInstance(request));

        var response = CreateProfileResponse.getInstance(savedProfile);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(savedProfile.getId()).toUri();

        return ResponseEntity.created(uri).body(response);

    }
}
