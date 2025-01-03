package br.com.alura.forumhub.controller.protocols;

 import org.springframework.data.domain.Page;
 import org.springframework.data.domain.Pageable;
 import org.springframework.http.ResponseEntity;


public interface SearchResourceController<Response>   {
    public ResponseEntity<Page<Response>> handle(Pageable pageable);
}
