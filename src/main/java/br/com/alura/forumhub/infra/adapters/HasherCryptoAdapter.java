package br.com.alura.forumhub.infra.adapters;

import br.com.alura.forumhub.domain.user.protocols.cryptography.Hasher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class HasherCryptoAdapter implements Hasher {

    private final BCryptPasswordEncoder crypto;

    public HasherCryptoAdapter(BCryptPasswordEncoder crypto) {
        this.crypto = crypto;
    }

    @Override
    public String hash(String plaintext) {
        return this.crypto.encode(plaintext);
    }
}
