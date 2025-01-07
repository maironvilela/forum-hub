package br.com.alura.forumhub.domain.profile.dtos;

import br.com.alura.forumhub.domain.profile.models.Profile;

public record CreateProfileResponse (Long id, Name name){

    public CreateProfileResponse(Long id, Name name) {
        this.id = id;
        this.name = name;
    }

    public static CreateProfileResponse getInstance(Profile profile){
        return new CreateProfileResponse(profile.getId(), profile.getName());
    }
}
