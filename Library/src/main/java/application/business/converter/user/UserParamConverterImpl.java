package application.business.converter.user;

import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.User;
import application.dataaccess.dao.userstatusdao.UserStatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserParamConverterImpl extends BaseParamConverterImpl<UserParam, User> implements UserParamConverter {
    @Autowired
    private UserStatusDao userStatusDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public User getEntity(UserParam param) {
        User user = new User();
        user.setId(param.getId());
        return user;
    }

    @Override
    public void convertSpecific(UserParam param, User entity) {
        entity.setUserStatus(userStatusDao.find(param.getUserStatusId()));
        entity.setPassword(encoder.encode(param.getPassword()));
    }
}
