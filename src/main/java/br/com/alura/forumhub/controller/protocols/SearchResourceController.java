package br.com.alura.forumhub.controller.protocols;

 import org.springframework.data.domain.Page;
 import org.springframework.data.domain.Pageable;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.ModelAttribute;


public interface SearchResourceController<Request, Response>   {
    public ResponseEntity<Page<Response>> handle(Pageable pageable, @ModelAttribute Request filter);

}


