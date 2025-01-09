package br.com.alura.forumhub.controller.users;

import br.com.alura.forumhub.controller.protocols.DeleteResourceController;
import br.com.alura.forumhub.domain.user.services.DeleteUserService;
import br.com.alura.forumhub.exceptions.shared.ResourceNotFoundException;
import br.com.alura.forumhub.infra.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class DeleteUserController implements DeleteResourceController{

    private final DeleteUserService deleteUserService;

    public DeleteUserController( DeleteUserService deleteUserService) {
        this.deleteUserService = deleteUserService;
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> handle(Long id) {
        this.deleteUserService.execute(id);
        return ResponseEntity.noContent().build();
    }
}
