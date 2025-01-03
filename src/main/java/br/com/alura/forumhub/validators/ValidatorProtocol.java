package br.com.alura.forumhub.validators;

public interface ValidatorProtocol<T> {
    void validar(T request);

}
