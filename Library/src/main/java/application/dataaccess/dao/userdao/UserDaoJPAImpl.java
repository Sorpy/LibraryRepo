package application.dataaccess.dao.userdao;

import application.data.entity.User;
import application.dataaccess.dao.common.commondao.BaseDaoJPAImpl;

public class UserDaoJPAImpl extends BaseDaoJPAImpl<User,Long> implements UserDao {
    @Override
    public Class<User> getMyType() {
        return User.class;
    }
}
