package application.authentication;

import application.data.entity.User;
import application.dataaccess.dao.userdao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BasicAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {


            if (null != authentication.getCredentials()) {

                String username = authentication.getName();
                String password = authentication.getCredentials().toString();

                User storedUser = userDao.getUser(username);

                String storedPassword = storedUser.getPassword();

                if (encoder.matches(password, storedPassword)) {

                    authentication = new UsernamePasswordAuthenticationToken(username,password);
                    return authentication;
                }
            }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
