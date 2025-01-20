package br.com.alura.forumhub.infra.repositories;

import br.com.alura.forumhub.domain.topic.models.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface TopicRepository extends JpaRepository <Topic, Long>, PagingAndSortingRepository<Topic, Long>, JpaSpecificationExecutor<Topic> {
    Boolean existsByTitleAndMessage(String title, String message);

    Page<Topic> findAllByCourseIdAndCreatedAtBetween(
            Long courseId,
            LocalDateTime startOfDay,
            LocalDateTime endOfDay,
            Pageable pageable);
}
