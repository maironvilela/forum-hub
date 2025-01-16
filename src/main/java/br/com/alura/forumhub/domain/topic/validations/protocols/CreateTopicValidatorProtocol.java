package br.com.alura.forumhub.domain.topic.validations.protocols;

public interface CreateTopicValidatorProtocol<T> {
    void validation(T request);
}
