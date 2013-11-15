package org.jks.web.security;

import org.jks.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.security.NoSuchAlgorithmException;
import java.util.Collection;

/**
 * @author juancarrillo
 */
@Component
public class RestAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        User user = null;

        try {
            user = restTemplate.getForObject("http://localhost:8080/service/user?username="+username, User.class);

        } catch (RestClientException e) {
            e.printStackTrace();
        }

        if (user == null) {
            throw new BadCredentialsException("user-not-found");
        }

        try {
            if (!User.sha1(password).equals(user.getPassword())) {
                throw new BadCredentialsException("wrong-password");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

        return new UsernamePasswordAuthenticationToken(username, password);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
