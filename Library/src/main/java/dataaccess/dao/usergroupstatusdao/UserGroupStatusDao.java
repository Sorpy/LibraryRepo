package dataaccess.dao.usergroupstatusdao;

import data.entity.UserGroupStatus;

import java.util.List;

public interface UserGroupStatusDao {
    UserGroupStatus save(UserGroupStatus entity);
    List<UserGroupStatus> save(List<UserGroupStatus> entity);

    UserGroupStatus update(UserGroupStatus entity);
    List<UserGroupStatus> update(List<UserGroupStatus> entity);

    void delete(long id);
    void delete(UserGroupStatus entity);
    void delete(List<Long> idList);


    List<UserGroupStatus> find();
    UserGroupStatus find(long id);
}
