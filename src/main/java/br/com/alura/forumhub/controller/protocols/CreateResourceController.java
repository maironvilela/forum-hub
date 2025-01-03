package br.com.alura.forumhub.controller.protocols;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

  public interface CreateResourceController<Request, Response>  {
      public ResponseEntity<Response> handle(@RequestBody @Valid Request request, UriComponentsBuilder uriBuilder);
}
