package dataaccess.dao.usergroupdao;

import data.entity.UserGroup;

import java.util.List;

public interface UserGroupDao {
    UserGroup save(UserGroup entity);
    List<UserGroup> save(List<UserGroup> entity);

    UserGroup update(UserGroup entity);
    List<UserGroup> update(List<UserGroup> entity);

    void delete(long id);
    void delete(UserGroup entity);
    void delete(List<Long> idList);

    List<UserGroup> find();
    UserGroup find(long id);
}
