package br.com.alura.forumhub.infra.exceptions.shared;

import br.com.alura.forumhub.infra.exceptions.AppException;

public class ResourceAlreadyExistsException extends AppException {
    public ResourceAlreadyExistsException(String path) {
        super(400, "Resource Already Exists", "ResourceAlreadyExistsException", path);
    }
}
