package application.dataaccess.dao.userdao;

import application.data.entity.User;
import application.dataaccess.dao.common.commondao.BaseDaoFileImpl;
public class UserDaoImpl extends BaseDaoFileImpl<User,Long, UserDataImpl> implements UserDao{

    @Override
    public Long getPK(User user) {
        return user.getId();
    }

    @Override
    public User getUser(String username) {
        return null;
    }
}
