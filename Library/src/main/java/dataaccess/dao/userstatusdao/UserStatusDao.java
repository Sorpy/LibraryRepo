package dataaccess.dao.userstatusdao;

import data.entity.UserStatus;

import java.util.List;

public interface UserStatusDao {
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
