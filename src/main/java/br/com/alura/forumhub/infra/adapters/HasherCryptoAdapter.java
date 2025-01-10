package br.com.alura.forumhub.infra.adapters;

import br.com.alura.forumhub.domain.user.protocols.cryptography.Hasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class HasherCryptoAdapter implements Hasher {

    @Autowired
    private PasswordEncoder crypto;


    @Override
    public String hash(String plaintext) {
        return this.crypto.encode(plaintext);
    }
}
