package br.com.alura.forumhub.infra.repositories;

import br.com.alura.forumhub.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
