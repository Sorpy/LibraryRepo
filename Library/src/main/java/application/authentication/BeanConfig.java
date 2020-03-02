package application.authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Primary
    public CustomAuthenticationFilter authFilter() {
        return new CustomAuthenticationFilter();
    }

    @Bean
    public SecurityContext securityContext() {
        new SecurityContextHolder();
        return SecurityContextHolder.getContext();
    }
}
