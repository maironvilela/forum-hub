package br.com.alura.forumhub.domain.course.validations;

public interface CourseValidatorProtocol<T> {
    void validation(T request);
}
