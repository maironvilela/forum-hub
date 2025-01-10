package br.com.alura.forumhub.domain.user.protocols.cryptography;

public interface Hasher {
    String hash (String plaintext);
}
