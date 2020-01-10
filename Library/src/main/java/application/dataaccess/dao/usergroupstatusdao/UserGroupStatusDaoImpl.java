package application.dataaccess.dao.usergroupstatusdao;

import application.data.entity.UserGroupStatus;
import application.dataaccess.dao.common.commondao.BaseDaoFileImpl;
public class UserGroupStatusDaoImpl extends BaseDaoFileImpl<UserGroupStatus,Long, UserGroupStatusDataImpl> implements UserGroupStatusDao{
    @Override
    public Long getPK(UserGroupStatus userGroupStatus) {
        return userGroupStatus.getId();
    }
}
