package br.com.alura.forumhub.controller.topic;

import br.com.alura.forumhub.controller.protocols.CreateResourceController;
import br.com.alura.forumhub.domain.topic.dtos.CreateTopicRequest;
import br.com.alura.forumhub.domain.topic.services.CreateTopicService;
 import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/topics")
public class CreateTopicController implements CreateResourceController<CreateTopicRequest, Void> {

    private final CreateTopicService createTopicService;

    public CreateTopicController(CreateTopicService createTopicService) {
        this.createTopicService = createTopicService;
    }

    @PostMapping
    @Override
    public ResponseEntity<Void> handle(CreateTopicRequest request, UriComponentsBuilder uriBuilder) {
        System.out.println(request);

        this.createTopicService.execute(request);

        return null;
    }
}
