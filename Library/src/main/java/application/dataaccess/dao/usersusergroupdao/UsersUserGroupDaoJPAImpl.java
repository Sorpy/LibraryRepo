package application.dataaccess.dao.usersusergroupdao;

import application.data.entity.UsersUserGroup;
import application.dataaccess.dao.common.commondao.BaseDaoJPAImpl;

public class UsersUserGroupDaoJPAImpl extends BaseDaoJPAImpl<UsersUserGroup,Long> implements UsersUserGroupDao {
    @Override
    public Class<UsersUserGroup> getMyType() {
        return UsersUserGroup.class;
    }
}
