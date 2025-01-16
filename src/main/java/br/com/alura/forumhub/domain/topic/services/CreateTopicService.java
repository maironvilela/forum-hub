package br.com.alura.forumhub.domain.topic.services;

import br.com.alura.forumhub.domain.course.models.Course;
import br.com.alura.forumhub.domain.topic.dtos.CreateTopicRequest;
import br.com.alura.forumhub.domain.topic.models.Topic;
import br.com.alura.forumhub.domain.topic.validations.protocols.IsTopicExists;
import br.com.alura.forumhub.domain.user.model.User;
import br.com.alura.forumhub.exceptions.shared.ResourceNotFoundException;
import br.com.alura.forumhub.infra.repositories.CourseRepository;
import br.com.alura.forumhub.infra.repositories.TopicRepository;
import br.com.alura.forumhub.infra.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CreateTopicService {

    private final TopicRepository topicRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;


    @Autowired
    private List<IsTopicExists> validations;

    public CreateTopicService(TopicRepository topicRepository, CourseRepository courseRepository, UserRepository userRepository) {
        this.topicRepository = topicRepository;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    public Topic execute(CreateTopicRequest request){
        validations.forEach(v -> v.validation(request));

        var course = this.loadCourse(Long.parseLong(request.courseId()));

        var author = this.loadAuthor(Long.parseLong(request.authorId()));

        var topic = new Topic(request.title(), request.message(), course,author);

        return this.topicRepository.save(topic);
    }

    private Course loadCourse(Long courseId){
        var optionalCourse = courseRepository.findById(courseId);

        if(optionalCourse.isEmpty()){
            throw new ResourceNotFoundException("Curso não encontrado", "/topics");
        }
        return optionalCourse.get();
    }

    private User loadAuthor(Long authorId){
        var optionalUser = userRepository.findById(authorId);

        if(optionalUser.isEmpty()){
            throw new ResourceNotFoundException("Autor não encontrado", "/topics");
        }
        return optionalUser.get();
    }
}
