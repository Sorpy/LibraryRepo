package application.dataaccess.dao.userdao;

import application.data.entity.User;
import application.dataaccess.dao.common.commondao.BaseDao;

public interface UserDao extends BaseDao<User, Long> {

    User getUser (String username);
}
