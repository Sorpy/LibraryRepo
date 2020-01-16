package application.dataaccess.dao.usergroupdao;

import application.data.entity.UserGroup;
import application.dataaccess.dao.common.commondao.BaseDaoJPAImpl;

public class UserGroupDaoJPAImpl extends BaseDaoJPAImpl<UserGroup,Long> implements UserGroupDao {
    @Override
    public Class<UserGroup> getMyType() {
        return UserGroup.class;
    }
}
