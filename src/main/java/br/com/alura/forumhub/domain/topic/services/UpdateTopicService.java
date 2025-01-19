package br.com.alura.forumhub.domain.topic.services;

import br.com.alura.forumhub.domain.course.models.Course;
import br.com.alura.forumhub.domain.topic.dtos.TopicResponse;
import br.com.alura.forumhub.domain.topic.dtos.UpdateTopicRequest;
import br.com.alura.forumhub.domain.topic.models.Topic;
import br.com.alura.forumhub.domain.user.model.User;
import br.com.alura.forumhub.exceptions.shared.ResourceNotFoundException;
import br.com.alura.forumhub.infra.repositories.CourseRepository;
import br.com.alura.forumhub.infra.repositories.TopicRepository;
import br.com.alura.forumhub.infra.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UpdateTopicService {

    private final TopicRepository topicRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public UpdateTopicService(TopicRepository topicRepository, UserRepository userRepository, CourseRepository courseRepository) {
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @Transactional
    public TopicResponse execute(UpdateTopicRequest request, Long id){

        var topic = loadTopic(id);
        User author = null;
        Course course = null;

        if(isShouldUpdate(request.authorId(), topic.getAuthor().getId())){
            author =  loadAuthor(Long.parseLong(request.authorId()));
        }

        if(isShouldUpdate(request.courseId(), topic.getCourse().getId())){
            course =  loadCourse(Long.parseLong(request.courseId()));
        }
        topic.update(request.title(), request.message(), course, author);
        return new TopicResponse(topic);
    }

    private Topic loadTopic(Long id) {
        var optionalTopic = this.topicRepository.findById(id);

        if(optionalTopic.isEmpty()){
            throw new ResourceNotFoundException("Topico não encontrado", "/topics/"+id);
        }
        return optionalTopic.get();
    }

    private Course loadCourse(Long id) {
        var optionaCourse = this.courseRepository.findById(id);

        if(optionaCourse.isEmpty()){
            throw new ResourceNotFoundException("Curso não encontrado", "/topics/"+id);
        }

        return optionaCourse.get();
    }

    private User loadAuthor(Long id) {
        var optionaAuthor = this.userRepository.findById(id);

        if(optionaAuthor.isEmpty()){
            throw new ResourceNotFoundException("Autor não encontrado", "/topics/"+id);
        }

        return optionaAuthor.get();
    }



    private boolean isShouldUpdate(String newId, Long currentId) {
        return newId != null && !newId.isEmpty() && !currentId.equals(Long.parseLong(newId));
    }
}
