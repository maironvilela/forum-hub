package br.com.alura.forumhub.domain.topic.services;

import br.com.alura.forumhub.domain.topic.Specification.TopicSpecifications;
import br.com.alura.forumhub.domain.topic.dtos.SearchTopicsRequest;
import br.com.alura.forumhub.domain.topic.models.Topic;
import br.com.alura.forumhub.infra.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SearchTopicService {
    @Autowired
    private TopicRepository topicRepository;

    public Page<Topic> findTopics(SearchTopicsRequest filter, Pageable pageable) {
        LocalDateTime startOfDay = null;
        LocalDateTime endOfDay = null;

        if(filter.createdAt() != null){
             startOfDay = filter.createdAt().atStartOfDay();
             endOfDay = filter.createdAt().atTime(23, 59, 59);
        }

        // Criação da Specification dinâmica
        Specification<Topic> spec = Specification.where(TopicSpecifications.hasCourseId(filter.courseId()))
                .and(TopicSpecifications.createdAtBetween(startOfDay, endOfDay));

        // Executando a consulta com a Specification e Pageable
        return topicRepository.findAll(spec, pageable);
    }
}
