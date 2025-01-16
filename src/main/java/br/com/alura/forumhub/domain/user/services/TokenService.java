package br.com.alura.forumhub.domain.user.services;

import br.com.alura.forumhub.domain.user.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private String JWT_KEY = "12345678";

    public String gerarToken(User user){

         try {
            var algoritimo = Algorithm.HMAC256(JWT_KEY);

            return  JWT.create()
                    .withIssuer("API ForumHub")
                    .withSubject(user.getEmail())
                    .withClaim("id", user.getId())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritimo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token jwt", exception);
        }
    }


    public String getSubjectByToken(String jwtToken){
         try{
            var algoritimo = Algorithm.HMAC256(JWT_KEY);

            return JWT.require(algoritimo)
                    .withIssuer("API ForumHub")
                    .build()
                    .verify(jwtToken)
                    .getSubject();

        }catch (JWTVerificationException exception){
            throw  new RuntimeException("Token JWT invalido ou expirado");
        }

    }


    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}



