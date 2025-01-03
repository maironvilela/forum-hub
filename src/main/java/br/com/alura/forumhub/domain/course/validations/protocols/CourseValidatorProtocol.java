package br.com.alura.forumhub.domain.course.validations.protocols;

public interface CourseValidatorProtocol<T> {
    void validation(T request);
}
