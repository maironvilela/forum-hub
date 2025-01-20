package br.com.alura.forumhub.domain.user.dtos;

import br.com.alura.forumhub.domain.profile.models.Profile;
import br.com.alura.forumhub.domain.user.model.User;

import java.util.List;

public record SearchUserResponse (
        Long id,
        String name,
        String email,
        List<Profile> profiles
) {

    public SearchUserResponse(Long id, String name, String email,   List<Profile> profiles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profiles = profiles;
    }

    public SearchUserResponse(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getProfiles());
    }
}
