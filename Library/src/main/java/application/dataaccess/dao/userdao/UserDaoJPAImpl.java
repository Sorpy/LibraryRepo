package application.dataaccess.dao.userdao;

import application.data.entity.User;
import application.dataaccess.dao.common.commondao.BaseDaoJPAImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Primary
@Component
public class UserDaoJPAImpl extends BaseDaoJPAImpl<User,Long> implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Class<User> getMyType() {
        return User.class;
    }

    @Transactional
    @Override
    public User getUser(String username) {
        List<User> user  = find("username",username);
        if (!user.isEmpty()) {
            return user.get(0);
        }
        else
            return null;
    }
}
