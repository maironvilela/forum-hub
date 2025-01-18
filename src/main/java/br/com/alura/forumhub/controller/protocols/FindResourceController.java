package br.com.alura.forumhub.controller.protocols;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


public interface FindResourceController<Response>   {
    public ResponseEntity<Response> handle(@PathVariable Long id);
}
