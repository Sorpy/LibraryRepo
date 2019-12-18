package application.dataaccess.dao.usergroupstatusdao;

import application.data.entity.UserGroupStatus;
import application.dataaccess.dao.common.BaseDao;

import java.util.List;

public interface UserGroupStatusDao extends BaseDao<UserGroupStatus, Long> {
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
