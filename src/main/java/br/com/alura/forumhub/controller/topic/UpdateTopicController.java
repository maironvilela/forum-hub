package br.com.alura.forumhub.controller.topic;

import br.com.alura.forumhub.controller.protocols.UpdateResourceController;
import br.com.alura.forumhub.domain.topic.dtos.TopicResponse;
import br.com.alura.forumhub.domain.topic.dtos.UpdateTopic;
import br.com.alura.forumhub.domain.topic.dtos.UpdateTopicRequest;
import br.com.alura.forumhub.domain.topic.services.UpdateTopicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("topics")
public class UpdateTopicController implements UpdateResourceController<UpdateTopicRequest, TopicResponse> {

    private final UpdateTopicService updateTopicService;

    public UpdateTopicController(UpdateTopicService updateTopicService) {
        this.updateTopicService = updateTopicService;
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<TopicResponse> handle(@PathVariable Long id, UpdateTopicRequest request) {
        var response = this.updateTopicService.execute(request, id);
        return ResponseEntity.ok(response);
    }
}
