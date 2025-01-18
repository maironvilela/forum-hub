package br.com.alura.forumhub.domain.topic.services;

import br.com.alura.forumhub.domain.topic.models.Topic;
import br.com.alura.forumhub.exceptions.shared.ResourceNotFoundException;
import br.com.alura.forumhub.infra.repositories.TopicRepository;
import org.springframework.stereotype.Service;

@Service
public class FindTopicByIdService {

    private final TopicRepository topicRepository;

    public FindTopicByIdService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic execute(Long id){
        var optionalUser = this.topicRepository.findById(id);

        if(optionalUser.isEmpty()){
            throw new ResourceNotFoundException("Usuario não encontrado", "/topic/"+id);
        }

        return optionalUser.get();
    }

}
