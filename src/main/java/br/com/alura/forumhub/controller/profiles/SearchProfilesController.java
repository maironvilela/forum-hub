package br.com.alura.forumhub.controller.profiles;

import br.com.alura.forumhub.controller.protocols.SearchResourceController;
import br.com.alura.forumhub.domain.profile.dtos.SearchProfilesResponse;
import br.com.alura.forumhub.infra.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("perfis")
public class SearchProfilesController implements SearchResourceController<SearchProfilesResponse> {

    @Autowired
    private ProfileRepository repository;

    @GetMapping
    @Override
    public ResponseEntity<Page<SearchProfilesResponse>> handle(@PageableDefault(sort = {"name"}) Pageable pageable) {
        var profile = this.repository.findAll(pageable);
        var response = profile.map(SearchProfilesResponse:: new);
        return ResponseEntity.ok(response);
     }
}
