package br.com.alura.forumhub.domain.topic.Specification;

import br.com.alura.forumhub.domain.topic.models.Topic;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class TopicSpecifications {

        public static Specification<Topic> hasCourseId(String courseId) {
            return (root, query, criteriaBuilder) -> {
                if (courseId != null) {
                    return criteriaBuilder.equal(root.get("course").get("id"), courseId);
                }
                return null;
            };
        }

        public static Specification<Topic> createdAtBetween(LocalDateTime startOfDay, LocalDateTime endOfDay) {
            return (root, query, criteriaBuilder) -> {
                if (startOfDay != null && endOfDay != null) {
                    return criteriaBuilder.between(root.get("createdAt"), startOfDay, endOfDay);
                }
                return null;
            };
        }
    }

