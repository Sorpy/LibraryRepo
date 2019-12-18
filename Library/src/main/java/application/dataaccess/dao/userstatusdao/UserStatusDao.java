package application.dataaccess.dao.userstatusdao;

import application.data.entity.UserStatus;
import application.dataaccess.dao.common.BaseDao;

import java.util.List;

public interface UserStatusDao extends BaseDao<UserStatus, Long> {
    UserStatus save(UserStatus entity);
    List<UserStatus> save(List<UserStatus> entity);

    UserStatus update(UserStatus entity);
    List<UserStatus> update(List<UserStatus> entity);

    void delete(long id);
    void delete(UserStatus entity);
    void delete(List<Long> idList);

    List<UserStatus> find();
    UserStatus find(long id);
}
