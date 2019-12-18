package application.dataaccess.dao.usergroupdao;

import application.data.entity.UserGroup;
import application.dataaccess.dao.common.BaseDao;

import java.util.List;

public interface UserGroupDao extends BaseDao<UserGroup, Long> {
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
