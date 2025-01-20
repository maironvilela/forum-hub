package br.com.alura.forumhub.controller.topic;

import br.com.alura.forumhub.controller.protocols.DeleteResourceController;
import br.com.alura.forumhub.domain.topic.services.DeleteTopicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class DeleteTopicController implements DeleteResourceController {

    private final DeleteTopicService deleteTopicService;

    public DeleteTopicController(DeleteTopicService deleteTopicService) {
        this.deleteTopicService = deleteTopicService;
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> handle(Long id) {
        this.deleteTopicService.execute(id);

        return ResponseEntity.noContent().build();
    }
}
