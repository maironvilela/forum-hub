package br.com.alura.forumhub.controller.protocols;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface DeleteResourceController {

    public ResponseEntity<Void> handle(@PathVariable Long id);

}
