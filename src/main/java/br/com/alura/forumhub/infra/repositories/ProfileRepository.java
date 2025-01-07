package br.com.alura.forumhub.infra.repositories;

import br.com.alura.forumhub.domain.profile.dtos.Name;
import br.com.alura.forumhub.domain.profile.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Profile getByName(Name name);
}
