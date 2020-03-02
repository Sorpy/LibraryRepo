package application.authentication;

import application.data.entity.User;
import application.data.entity.UsernamePasswordTokenAuthenticationToken;
import application.dataaccess.dao.userdao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BasicAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserDao userDao;

    @Autowired
    private Credentials credentials;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        UsernamePasswordTokenAuthenticationToken authenticationToken = (UsernamePasswordTokenAuthenticationToken) authentication ;

        if (authenticationToken != null) {

            if (null != authentication.getCredentials()) {

                String username = authentication.getName();
                String password = authentication.getCredentials().toString();


                User storedUser = userDao.getUser(username);
                if (storedUser!=null) {
                    String storedPassword = storedUser.getPassword();

                    if (encoder.matches(password,storedPassword)) {


                        authentication = new UsernamePasswordTokenAuthenticationToken(username, password);
                        return authentication;

                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
