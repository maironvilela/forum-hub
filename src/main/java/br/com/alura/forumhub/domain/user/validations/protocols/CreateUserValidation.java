package br.com.alura.forumhub.domain.user.validations.protocols;

public interface CreateUserValidation<T> {
    void validation(T request);
}
