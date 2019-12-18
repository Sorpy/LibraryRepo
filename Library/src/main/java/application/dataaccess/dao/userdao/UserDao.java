package application.dataaccess.dao.userdao;

import application.data.entity.User;
import application.dataaccess.dao.common.BaseDao;

import java.util.List;

public interface UserDao extends BaseDao<User, Long> {
    User save(User entity);
    List<User> save(List<User> entity);

    User update(User entity);
    List<User> update(List<User> entity);

    void delete(Long id);
    void delete(User entity);
    void delete(List<Long> idList);

    List<User> find();
    User find(Long id);
}
