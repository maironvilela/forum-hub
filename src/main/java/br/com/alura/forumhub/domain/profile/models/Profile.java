package br.com.alura.forumhub.domain.profile.models;

import br.com.alura.forumhub.controller.profiles.dtos.CreateProfileRequest;
import br.com.alura.forumhub.controller.profiles.dtos.Name;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity(name = "Profile")
@Table(name = "profiles")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Name name;

    public static Profile getInstance(CreateProfileRequest request) {
        return new Profile(null, request.name());

    }



}



