package br.com.alura.forumhub.controller.topic;

import br.com.alura.forumhub.controller.protocols.FindResourceController;
import br.com.alura.forumhub.domain.topic.dtos.TopicResponse;
import br.com.alura.forumhub.domain.topic.services.FindTopicByIdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class FindTopicByIdController implements FindResourceController<TopicResponse> {
    private final FindTopicByIdService searchTopicByIdService;

    public FindTopicByIdController(FindTopicByIdService searchTopicByIdService) {
        this.searchTopicByIdService = searchTopicByIdService;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<TopicResponse> handle(Long id) {
        System.out.println("ID: "+ id);
        var topic = this.searchTopicByIdService.execute(id);
        var response = new TopicResponse(topic);
        return ResponseEntity.ok(response);
    }
}
