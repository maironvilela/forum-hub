package br.com.alura.forumhub.infra.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AppException extends RuntimeException{
    private Integer statusCode;
    private String message;
    private String error;
    private String path;
}


