package application.dataaccess.dao.usersusergroupdao;

import application.data.entity.UsersUserGroup;
import application.dataaccess.dao.common.BaseDao;

import java.util.List;

public interface UsersUserGroupDao extends BaseDao<UsersUserGroup, Long> {
    UsersUserGroup save(UsersUserGroup entity);
    List<UsersUserGroup> save(List<UsersUserGroup> entity);

    UsersUserGroup update(UsersUserGroup entity);
    List<UsersUserGroup> update(List<UsersUserGroup> entity);

    void delete(long id);
    void delete(UsersUserGroup entity);
    void delete(List<Long> idList);

    List<UsersUserGroup> find();
    UsersUserGroup find(long id);
}
