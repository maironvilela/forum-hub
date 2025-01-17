package br.com.alura.forumhub.utils;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class GetUriResources {
    public static URI buildUri(UriComponentsBuilder uriBuilder, Long id){
        return uriBuilder.path("/topics/{id}").buildAndExpand(id).toUri();
    }
}
