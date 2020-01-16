package application.dataaccess.dao.usergroupstatusdao;

import application.data.entity.UserGroupStatus;
import application.dataaccess.dao.common.commondao.BaseDaoJPAImpl;

public class UserGroupStatusDaoJPAImpl extends BaseDaoJPAImpl<UserGroupStatus,Long> implements UserGroupStatusDao {
    @Override
    public Class<UserGroupStatus> getMyType() {
        return UserGroupStatus.class;
    }
}
