package br.com.alura.forumhub.infra.repositories;

import br.com.alura.forumhub.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmailAndIdNot(String email, Long id);
}
