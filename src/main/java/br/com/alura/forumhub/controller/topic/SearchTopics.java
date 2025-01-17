package br.com.alura.forumhub.controller.topic;

import br.com.alura.forumhub.controller.course.dtos.SearchCourserResponse;
import br.com.alura.forumhub.controller.protocols.SearchResourceController;
import br.com.alura.forumhub.domain.topic.dtos.TopicResponse;
import br.com.alura.forumhub.infra.repositories.TopicRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class SearchTopics implements SearchResourceController<TopicResponse> {

    private final TopicRepository topicRepository;

    public SearchTopics(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @GetMapping
    @Override
    public ResponseEntity<Page<TopicResponse>> handle(@PageableDefault(size = 10,page = 0, sort = {"createdAt"}, direction = Sort.Direction.ASC
    ) Pageable pageable) {
        var topics = this.topicRepository.findAll(pageable);
        var response = topics.map(TopicResponse:: new);
        return ResponseEntity.ok(response);

    }
}


