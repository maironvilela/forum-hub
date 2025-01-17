package br.com.alura.forumhub.controller.topic;

import br.com.alura.forumhub.controller.protocols.CreateResourceController;
import br.com.alura.forumhub.domain.topic.dtos.CreateTopicRequest;
import br.com.alura.forumhub.domain.topic.dtos.TopicResponse;
import br.com.alura.forumhub.domain.topic.services.CreateTopicService;
import br.com.alura.forumhub.utils.GetUriResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/topics")
public class CreateTopicController implements CreateResourceController<CreateTopicRequest, TopicResponse> {

    private final CreateTopicService createTopicService;

    public CreateTopicController(CreateTopicService createTopicService) {
        this.createTopicService = createTopicService;
    }

    @PostMapping
    @Override
    public ResponseEntity<TopicResponse> handle(CreateTopicRequest request, UriComponentsBuilder uriBuilder) {
        var savedTopic = this.createTopicService.execute(request);
        var response = new TopicResponse(savedTopic);
        var uri = GetUriResources.buildUri(uriBuilder,savedTopic.getId());
        return ResponseEntity.created(uri).body(response);
    }
}
