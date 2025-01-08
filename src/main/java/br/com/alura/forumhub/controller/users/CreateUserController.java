package br.com.alura.forumhub.controller.users;

import br.com.alura.forumhub.controller.protocols.CreateResourceController;
import br.com.alura.forumhub.domain.user.dtos.CreateUserRequest;
import br.com.alura.forumhub.domain.user.dtos.CreateUserResponse;
import br.com.alura.forumhub.domain.user.services.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("users")
public class CreateUserController implements CreateResourceController<CreateUserRequest, CreateUserResponse> {
    private final CreateUserService createUserService;

    public CreateUserController(CreateUserService createUserService){
        this.createUserService = createUserService;
    }

    @PostMapping
    @Override
    public ResponseEntity<CreateUserResponse> handle(CreateUserRequest request, UriComponentsBuilder uriBuilder) {
        var savedUser = this.createUserService.execute(request);
        return ResponseEntity.ok(new CreateUserResponse(savedUser));
    }
}
