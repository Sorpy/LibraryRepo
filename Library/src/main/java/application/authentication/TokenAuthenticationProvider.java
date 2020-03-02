package application.authentication;

import application.business.converter.user.UserResult;
import application.business.processor.userprocessor.UserProcessor;
import application.data.entity.ApiSession;
import application.data.entity.UsernamePasswordTokenAuthenticationToken;
import application.dataaccess.dao.apisessiondao.ApiSessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private Credentials credentials;

    @Autowired
    private ApiSessionDao apiSessionDao;

    @Autowired
    private UserProcessor userProcessor;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordTokenAuthenticationToken authenticationToken = (UsernamePasswordTokenAuthenticationToken) authentication ;

        if (authenticationToken != null) {

            if (null != authenticationToken.getAuthToken()) {

                String authToken = authenticationToken.getAuthToken();

                ApiSession apiSession = apiSessionDao.getSession(authToken);

                if (apiSession!=null) {
                    UserResult userResult = userProcessor.getUser(apiSession.getName());
                    if (userResult != null)
                        authentication = new UsernamePasswordTokenAuthenticationToken(userResult.getUsername(), userResult.getPassword(),authToken);
                    return authentication;
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
