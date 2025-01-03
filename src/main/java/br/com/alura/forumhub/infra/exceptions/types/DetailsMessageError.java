package br.com.alura.forumhub.infra.exceptions.types;

import br.com.alura.forumhub.infra.exceptions.shared.ResourceAlreadyExistsException;
import br.com.alura.forumhub.infra.exceptions.shared.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record DetailsMessageError(
        String path,
        String error,
        String message,
        String dateTime
) {

    public DetailsMessageError(String path, String error, String message, String dateTime) {
        this.path = path;
        this.error = error;
        this.message = message;
        this.dateTime = dateTime;
    }

    public DetailsMessageError(ResourceAlreadyExistsException exception) {
        this(exception.getPath(), exception.getError(),exception.getMessage(), getDataTime());
    }

    public DetailsMessageError(ResourceNotFoundException exception) {
        this(exception.getPath(), exception.getError(),exception.getMessage(), getDataTime());
    }

    private static String getDataTime(){
        LocalDateTime dateTimeAtual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dateTimeAtual.format(formatter);
    }
}
