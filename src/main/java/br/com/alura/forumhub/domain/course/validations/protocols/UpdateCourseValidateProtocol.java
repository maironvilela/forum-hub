package br.com.alura.forumhub.domain.course.validations.protocols;

public interface UpdateCourseValidateProtocol<Request> {
    public void valid(Request request, Long id);
}
