package br.com.alura.forumhub.controller.profiles.dtos;

import br.com.alura.forumhub.domain.profile.models.Profile;

public record SearchProfilesResponse(Long id, Name name){

    public SearchProfilesResponse(Long id, Name name) {
        this.id = id;
        this.name = name;
    }

    public SearchProfilesResponse(Profile profile) {
        this(profile.getId(), profile.getName());
    }

    public static SearchProfilesResponse getInstance(Profile profile){
        return new SearchProfilesResponse(profile.getId(), profile.getName());
    }
}
