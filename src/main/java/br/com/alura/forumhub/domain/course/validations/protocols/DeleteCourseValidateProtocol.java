package br.com.alura.forumhub.domain.course.validations.protocols;

public interface DeleteCourseValidateProtocol<T> {
    public void valid(T value);
}
