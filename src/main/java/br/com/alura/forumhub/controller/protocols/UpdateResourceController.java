package br.com.alura.forumhub.controller.protocols;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface UpdateResourceController<Request, Response> {

    public ResponseEntity<Response> handle(@PathVariable Long id, @RequestBody @Valid Request request);
}
