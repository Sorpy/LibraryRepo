package application.business.processor.userprocessor;

import application.business.converter.user.UserParam;
import application.business.converter.user.UserParamConverter;
import application.business.converter.user.UserResult;
import application.business.converter.user.UserResultConverter;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.User;
import application.dataaccess.dao.userdao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserProcessorImpl
        extends BaseProcessorImpl<UserParam, User, UserResult,Long,UserDao,UserParamConverter,UserResultConverter>
        implements UserProcessor, UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public Long getPK(UserParam ent) {
        return ent.getId();

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUser(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
