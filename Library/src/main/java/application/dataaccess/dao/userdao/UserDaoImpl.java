package application.dataaccess.dao.userdao;

import application.data.entity.User;
import application.dataaccess.dao.common.commondao.BaseDaoFileImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl extends BaseDaoFileImpl<User,Long, UserDataImpl> implements UserDao{

    @Override
    public Long getPK(User user) {
        return user.getId();
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void delete(List<Long> idList) {

    }
}
