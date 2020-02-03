package application.dataaccess.dao.userdao;

import application.data.entity.User;
import application.dataaccess.dao.common.commondao.BaseDaoJPAImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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
        return (User) entityManager.createQuery("SELECT u FROM UserInfo u WHERE userName=?")
                .setParameter(1,username).getSingleResult();
    }
}
