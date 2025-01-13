package br.com.alura.forumhub.controller.protocols;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthControllerProtocol<Request, Response>  {
    public ResponseEntity<Response> handle(@RequestBody @Valid Request request);
}
