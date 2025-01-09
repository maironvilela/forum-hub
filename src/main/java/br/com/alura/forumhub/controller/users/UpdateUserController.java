package br.com.alura.forumhub.controller.users;

import br.com.alura.forumhub.controller.course.dtos.UpdateCourseResponse;
import br.com.alura.forumhub.controller.protocols.UpdateResourceController;
import br.com.alura.forumhub.controller.users.dtos.UpdateUserRequest;
import br.com.alura.forumhub.controller.users.dtos.UpdateUserResponse;
import br.com.alura.forumhub.domain.user.services.UpdateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UpdateUserController implements UpdateResourceController<UpdateUserRequest, UpdateUserResponse> {

    private final UpdateUserService updateUserService;

    public UpdateUserController(UpdateUserService updateUserService) {
        this.updateUserService = updateUserService;
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<UpdateUserResponse> handle(Long id, UpdateUserRequest request) {

        var user = this.updateUserService.execute(request, id);

        return ResponseEntity.ok().body(new UpdateUserResponse(user));
    }
}
