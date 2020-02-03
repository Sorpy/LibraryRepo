package application.authentication;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AuthenticationManager extends ProviderManager {

    public AuthenticationManager(List<AuthenticationProvider> providers) {
        super(providers);
    }
}
