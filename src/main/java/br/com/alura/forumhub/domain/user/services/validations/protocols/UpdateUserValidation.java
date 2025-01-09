package br.com.alura.forumhub.domain.user.services.validations.protocols;

public interface UpdateUserValidation<T> {
    void validation(T request);
}
