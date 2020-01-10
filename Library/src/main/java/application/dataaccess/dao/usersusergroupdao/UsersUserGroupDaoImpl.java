package application.dataaccess.dao.usersusergroupdao;

import application.data.entity.UsersUserGroup;
import application.dataaccess.dao.common.commondao.BaseDaoFileImpl;
public class UsersUserGroupDaoImpl extends BaseDaoFileImpl<UsersUserGroup,Long, UsersUserGroupDataImpl> implements UsersUserGroupDao {

    @Override
    public Long getPK(UsersUserGroup usersUserGroup) {
        return usersUserGroup.getId();
    }
}
