package br.com.alura.forumhub.domain.topic.services;

import br.com.alura.forumhub.exceptions.shared.ResourceNotFoundException;
import br.com.alura.forumhub.infra.repositories.TopicRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteTopicService {

    private final TopicRepository topicRepository;

    public DeleteTopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public void execute(Long id){
        var topicIsExists = this.topicRepository.existsById(id);
        if(!topicIsExists){
            throw new ResourceNotFoundException("Topico nao encontrado", "/topics/"+id);
        }
        this.topicRepository.deleteById(id);
    }
}
