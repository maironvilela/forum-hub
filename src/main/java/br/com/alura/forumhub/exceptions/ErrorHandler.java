package br.com.alura.forumhub.exceptions;


import br.com.alura.forumhub.exceptions.shared.ResourceAlreadyExistsException;
import br.com.alura.forumhub.exceptions.shared.ResourceNotFoundException;
import br.com.alura.forumhub.exceptions.types.DataErrorValidation;
import br.com.alura.forumhub.exceptions.types.DetailsMessageError;
import br.com.alura.forumhub.exceptions.types.MensagemErro;
import br.com.alura.forumhub.exceptions.users.AuthenticationFailureException;
import br.com.alura.forumhub.exceptions.users.EmailAlreadyExistsException;
import br.com.alura.forumhub.exceptions.users.ProfileValidationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import java.util.List;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<MensagemErro> badRequest(BadRequest exception) {

        return ResponseEntity.badRequest().body(new MensagemErro(exception.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DataErrorValidation>> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        var erros = exception.getFieldErrors();
        var listErrors = erros.stream().map(DataErrorValidation::new).toList();
        return ResponseEntity.badRequest().body(listErrors);


    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<MensagemErro> httpMessageNotReadableException(JsonMappingException exception) {
        String invalidValue = exception.getPath().getFirst().getFieldName();
        //String acceptedValues = Arrays.toString(Category.values());
        String acceptedValues =  exception.getMessage().split(":")[2].split("\n")[0];

        String message = String.format("O valor '%s' não é aceito. Valores válidos: %s", invalidValue,acceptedValues);



        return ResponseEntity.badRequest().body(new MensagemErro(message));
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<DetailsMessageError> resourceAlreadyExistsException(ResourceAlreadyExistsException exception) {

        return ResponseEntity.badRequest().body(new DetailsMessageError(exception));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<DetailsMessageError> resourceNotFoundException(ResourceNotFoundException exception) {
         return ResponseEntity.badRequest().body(new DetailsMessageError(exception));
    }

    @ExceptionHandler(ProfileValidationException.class)
    public ResponseEntity<DetailsMessageError> profileValidationException(ProfileValidationException exception) {
        return ResponseEntity.badRequest().body(new DetailsMessageError(exception));
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<DetailsMessageError> emailAlreadyExistsException(EmailAlreadyExistsException exception) {
        return ResponseEntity.badRequest().body(new DetailsMessageError(exception));
    }


    @ExceptionHandler(AuthenticationFailureException.class)
    public ResponseEntity<DetailsMessageError> authenticationFailureException(AuthenticationFailureException exception) {
        return ResponseEntity.badRequest().body(new DetailsMessageError(exception));
    }


}