package br.com.alura.forumhub.controller.users;

import br.com.alura.forumhub.controller.protocols.SearchResourceController;
import br.com.alura.forumhub.domain.user.dtos.SearchUserRequest;
import br.com.alura.forumhub.domain.user.dtos.SearchUserResponse;
import br.com.alura.forumhub.infra.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class SearchUsersController implements SearchResourceController<SearchUserRequest, SearchUserResponse> {

    private final UserRepository userRepository;

    public SearchUsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    @Override
    public ResponseEntity<Page<SearchUserResponse>> handle(@PageableDefault(size = 10, page = 0, sort = {"name"}) Pageable pageable, SearchUserRequest filter) {
        var users = this.userRepository.findAll(pageable);

        var response = users.map(SearchUserResponse :: new);
        return ResponseEntity.ok(response);
    }
}

