package br.com.alura.forumhub.domain.topic.validations.protocols;

import br.com.alura.forumhub.domain.topic.dtos.CreateTopicRequest;
import br.com.alura.forumhub.exceptions.shared.ResourceAlreadyExistsException;
import br.com.alura.forumhub.infra.repositories.CourseRepository;
import br.com.alura.forumhub.infra.repositories.TopicRepository;
import br.com.alura.forumhub.infra.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class IsTopicExists implements CreateTopicValidatorProtocol<CreateTopicRequest>{
    private final TopicRepository topicRepository;

    public IsTopicExists(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public void validation(CreateTopicRequest request) {
        var isTopocExist = this.topicRepository.existsByTitleAndMessage(request.title(), request.message());
        if(isTopocExist){
            throw new ResourceAlreadyExistsException("/topics", "Tópico já existe");
        }
    }
}
