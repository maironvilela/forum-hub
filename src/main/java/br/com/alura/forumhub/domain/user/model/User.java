package br.com.alura.forumhub.domain.user.model;

import br.com.alura.forumhub.controller.users.dtos.UpdateUserRequest;
import br.com.alura.forumhub.domain.profile.models.Profile;
import br.com.alura.forumhub.controller.users.dtos.CreateUserRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    String password;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
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

    public void update(UpdateUserRequest request, List<Profile> profiles){
        this.name = this.fieldValid(request.name())? this.name: request.name();
        this.email = this.fieldValid(request.email())?  this.email: request.email();
        this.password = this.fieldValid(request.password())?  this.name : request.password();
        this.profiles = this.profiles.isEmpty()?this.profiles: profiles;
     }

    private boolean fieldValid(String field){
         return field.trim().isEmpty();
    }




}
