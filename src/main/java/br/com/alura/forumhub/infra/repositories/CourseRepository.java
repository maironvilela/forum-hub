package br.com.alura.forumhub.infra.repositories;

import br.com.alura.forumhub.domain.course.models.Course;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByName(@NotBlank(message = "Campo obrigatório") String name);
}
