package application.data.entity;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


public class UsernamePasswordTokenAuthenticationToken extends UsernamePasswordAuthenticationToken{


    private static final long serialVersionUID = 1L;

    private String authToken;

    public UsernamePasswordTokenAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public UsernamePasswordTokenAuthenticationToken(Object principal, Object credentials, String authToken) {
        super(principal, credentials);
        this.authToken = authToken;
    }

    public UsernamePasswordTokenAuthenticationToken(String username, String password, String authToken,
                                                    Collection<? extends GrantedAuthority> userAuthorities) {
        super(username, password, userAuthorities);
        this.authToken = authToken;
    }

    public UsernamePasswordTokenAuthenticationToken(String username, String password,
                                                    Collection<? extends GrantedAuthority> userAuthorities) {
        super(username, password, userAuthorities);
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

}