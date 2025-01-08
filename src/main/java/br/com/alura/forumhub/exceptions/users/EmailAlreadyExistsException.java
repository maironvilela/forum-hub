package br.com.alura.forumhub.exceptions.users;

import br.com.alura.forumhub.exceptions.AppException;

public class EmailAlreadyExistsException extends AppException {

    public EmailAlreadyExistsException(String message, String path) {
        super(400, message, "EmailAlreadyExistsException", path);
    }
}
