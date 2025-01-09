package br.com.alura.forumhub.domain.user.services.validations.protocols;

public interface CreateUserValidation<T> {
    void validation(T request);
}
