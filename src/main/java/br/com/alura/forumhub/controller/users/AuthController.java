package br.com.alura.forumhub.controller.users;

import br.com.alura.forumhub.controller.protocols.AuthControllerProtocol;
import br.com.alura.forumhub.domain.user.dtos.AuthRequest;
import br.com.alura.forumhub.domain.user.dtos.AuthResponse;
import br.com.alura.forumhub.domain.user.model.User;
import br.com.alura.forumhub.domain.user.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController implements AuthControllerProtocol<AuthRequest, AuthResponse> {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Override
    public ResponseEntity<AuthResponse> handle(AuthRequest request) {
        var token = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        var authenticatieUser = (User) manager.authenticate(token).getPrincipal();
        var response = new AuthResponse(this.tokenService.gerarToken(authenticatieUser));
        return ResponseEntity.ok(response);
    }
}
