package application.business.processor.authentication;

import application.authentication.Credentials;
import application.data.entity.ApiSession;
import application.data.entity.User;
import application.data.entity.UsernamePasswordTokenAuthenticationToken;
import application.dataaccess.dao.apisessiondao.ApiSessionDao;
import application.dataaccess.dao.userdao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AuthenticationProcessorImpl implements AuthenticationProcessor {

    @Autowired
    private Credentials credentials;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ApiSessionDao apiSessionDao;


    @Override
    public String login() {
        User user = userDao.getUser(credentials.getAuthentication().getPrincipal().toString());
        ApiSession apiSession = new ApiSession();
        apiSession.setCode(user.getUserStatus().getName());
        //apiSession.setId(user.getId());
        apiSession.setDescription("Session created on " + java.time.LocalDateTime.now());
        apiSession.setName(user.getUsername());
        apiSession.setActive((byte)1);
        apiSession.setAuthToken(UUID.randomUUID().toString());

        apiSessionDao.save(apiSession);
        return apiSession.getAuthToken();

    }

    @Override
    public void logout() {
        Authentication authentication = credentials.getAuthentication();
        UsernamePasswordTokenAuthenticationToken authenticationToken = (UsernamePasswordTokenAuthenticationToken) authentication;
        ApiSession apiSession = apiSessionDao.getSession(authenticationToken.getAuthToken());

        if (apiSession!=null){
            apiSessionDao.delete(apiSession);
        }

    }
}
