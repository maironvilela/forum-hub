package br.com.alura.forumhub.infra.repositories;

import br.com.alura.forumhub.domain.topic.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository <Topic, Long>{
    Boolean existsByTitleAndMessage(String title, String message);
}
