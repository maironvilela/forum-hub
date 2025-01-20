package br.com.alura.forumhub.controller.topic;

import br.com.alura.forumhub.controller.protocols.SearchResourceController;
import br.com.alura.forumhub.domain.topic.dtos.SearchTopicsRequest;
 import br.com.alura.forumhub.domain.topic.dtos.TopicResponse;
import br.com.alura.forumhub.domain.topic.services.SearchTopicService;
import br.com.alura.forumhub.infra.repositories.TopicRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/topics")
public class SearchTopicsController implements SearchResourceController<SearchTopicsRequest, TopicResponse> {

    private final TopicRepository topicRepository;
    private final SearchTopicService searchTopicService;

    public SearchTopicsController(TopicRepository topicRepository, SearchTopicService searchTopicService) {
        this.searchTopicService = searchTopicService;
        this.topicRepository = topicRepository;
    }

    @GetMapping
    @Override
    public ResponseEntity<Page<TopicResponse>> handle(@PageableDefault(size = 10,page = 0, sort = {"createdAt"}, direction = Sort.Direction.ASC
    ) Pageable pageable, SearchTopicsRequest filter) {



        var topics = this.searchTopicService.findTopics(filter, pageable);
/*
        var topics  = this.topicRepository.findAllByCourseIdAndCreatedAtBetween(
                Long.parseLong(filter.courseId()),
                startOfDay,
                endOfDay,
                pageable);*/

       // var topics = this.topicRepository.searchWithFilter(filter.courseId(), filter.createdAt(), pageable);
        if(topics != null) {
            var response = topics.map(TopicResponse::new);
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.notFound().build();

         //return ResponseEntity.ok( ).build();

    }
}


