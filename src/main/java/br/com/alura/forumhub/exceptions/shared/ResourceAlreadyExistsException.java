package br.com.alura.forumhub.exceptions.shared;

import br.com.alura.forumhub.exceptions.AppException;

public class ResourceAlreadyExistsException extends AppException {
    public ResourceAlreadyExistsException(String path, String message) {
        super(400, message, "ResourceAlreadyExistsException", path);
    }
}
