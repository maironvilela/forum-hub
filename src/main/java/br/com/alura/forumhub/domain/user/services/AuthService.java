package br.com.alura.forumhub.domain.user.services;


import br.com.alura.forumhub.exceptions.users.AuthenticationFailureException;
import br.com.alura.forumhub.infra.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
 public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userOptional =  this.userRepository.findByEmail(username);
        if(userOptional.isEmpty()){
            throw new AuthenticationFailureException("Falha na autenticação","/auth");
        }

        System.out.println(userOptional.get());
        return userOptional.get();
    }
}
