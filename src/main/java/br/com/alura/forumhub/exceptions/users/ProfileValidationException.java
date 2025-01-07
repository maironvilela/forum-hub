package br.com.alura.forumhub.exceptions.users;

import br.com.alura.forumhub.exceptions.AppException;

public class ProfileValidationException extends AppException  {
    public ProfileValidationException(String message, String path) {
        super(400, message, "ProfileValidationException", path);
    }
}
