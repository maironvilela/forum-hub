package br.com.alura.forumhub.controller.users.dtos;

import br.com.alura.forumhub.domain.profile.models.Profile;
import br.com.alura.forumhub.domain.user.model.User;

import java.util.List;

public record CreateUserResponse(
        Long id,
        String name,
        String email,
        List<Profile> profiles

) {

    public CreateUserResponse(Long id, String name, String email, List<Profile> profiles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profiles = profiles;
    }

    public CreateUserResponse(User user) {
        this(user.getId(),user.getName(),user.getEmail(),user.getProfiles());
    }
}
