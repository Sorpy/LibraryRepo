package application.authentication;


import application.data.entity.BasicAuthenticationEnt;
import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Filter(name = "preAuthFilter")
@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private Credentials credetentials;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        Authentication auth = credetentials.getAuthentication();
            UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) auth;

            if (authentication == null) {
                authentication = basicAuthentication((HttpServletRequest) request);
            }

            SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request,response);


    }

    private UsernamePasswordAuthenticationToken basicAuthentication(HttpServletRequest httpRequest) {

        BasicAuthenticationEnt basicAuthHeader = new BasicAuthenticationEnt(
                httpRequest.getHeader("Authorization"));

        if (basicAuthHeader!=null) {
            String username = basicAuthHeader.getUsername();
            String password = basicAuthHeader.getPassword();

            return new UsernamePasswordAuthenticationToken(username,
                    password);
        }
        return null;
    }
}
