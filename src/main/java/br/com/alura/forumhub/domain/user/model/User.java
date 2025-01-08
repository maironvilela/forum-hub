package br.com.alura.forumhub.domain.user.model;

import br.com.alura.forumhub.domain.profile.models.Profile;
import br.com.alura.forumhub.domain.user.dtos.CreateUserRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    String password;

    @ManyToMany
    @JoinTable(
            name = "users_profiles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id")
    )
    List<Profile> profiles = new ArrayList<>();

    public User( String name, String email, String password, List<Profile> profiles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.profiles = profiles;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
     }

    public static User getInstance(CreateUserRequest request, String hashedPassword) {
        return new User(request.name(), request.email(), hashedPassword);
    }


}
