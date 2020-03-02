package application.authentication;


import application.data.entity.BasicAuthenticationEnt;
import application.data.entity.UsernamePasswordTokenAuthenticationToken;
import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Filter(name = "authFilter")
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private Credentials credetentials;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        Authentication auth = credetentials.getAuthentication();

        UsernamePasswordTokenAuthenticationToken authentication = (UsernamePasswordTokenAuthenticationToken) auth;


            if (authentication == null) {
                authentication = tokenAuthentication(request);
            }

            if (authentication == null) {
                authentication = basicAuthentication(request);
            }

            SecurityContextHolder.getContext().setAuthentication(authentication);


       filterChain.doFilter(request,response);


    }

    private UsernamePasswordTokenAuthenticationToken tokenAuthentication(HttpServletRequest httpRequest) {
        if (!httpRequest.getHeader("Authorization").contains("Basic")) {
            return new UsernamePasswordTokenAuthenticationToken("","",
                    httpRequest.getHeader("Authorization").trim());
        }
        return null;
    }

    private UsernamePasswordTokenAuthenticationToken basicAuthentication(HttpServletRequest httpRequest) {


        if (httpRequest.getHeader("Authorization").contains("Basic")) {

            BasicAuthenticationEnt basicAuthHeader = new BasicAuthenticationEnt(
                httpRequest.getHeader("Authorization"));
            if (basicAuthHeader != null) {
                String username = basicAuthHeader.getUsername();
                String password = basicAuthHeader.getPassword();

                return new UsernamePasswordTokenAuthenticationToken(username,
                        password);
            }
        }
        return null;
    }
}
