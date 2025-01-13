package br.com.alura.forumhub.exceptions.users;

import br.com.alura.forumhub.exceptions.AppException;

public class AuthenticationFailureException extends AppException  {
    public AuthenticationFailureException(String message, String path) {
        super(401, message, "AuthenticationFailureException", path);
    }
}
