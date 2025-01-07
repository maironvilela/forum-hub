package br.com.alura.forumhub.exceptions.shared;

import br.com.alura.forumhub.exceptions.AppException;

public class ResourceNotFoundException extends AppException {
    public ResourceNotFoundException(String path) {
        super(400, "Resource Not Exists", "ResourceNotFoundException", path);
    }
}
