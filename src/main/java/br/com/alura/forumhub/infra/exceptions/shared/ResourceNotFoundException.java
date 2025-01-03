package br.com.alura.forumhub.infra.exceptions.shared;

import br.com.alura.forumhub.infra.exceptions.AppException;

public class ResourceNotFoundException extends AppException {
    public ResourceNotFoundException(String path) {
        super(400, "Resource Not Exists", "ResourceNotFoundException", path);
    }
}
