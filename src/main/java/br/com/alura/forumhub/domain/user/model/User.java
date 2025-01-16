package br.com.alura.forumhub.domain.user.model;

import br.com.alura.forumhub.controller.users.dtos.UpdateUserRequest;
import br.com.alura.forumhub.domain.profile.models.Profile;
import br.com.alura.forumhub.controller.users.dtos.CreateUserRequest;
import br.com.alura.forumhub.domain.topic.models.Topic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name="users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_profiles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id")
    )
    private List<Profile> profiles = new ArrayList<>();




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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return profiles.stream()
                .map(profile -> (GrantedAuthority) () -> profile.getName().name())
                .toList();
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public String getPassword() {
        return password;
    }

    /*

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }*/
}
