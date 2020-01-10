package application.dataaccess.dao.userstatusdao;

import application.data.entity.UserStatus;
import application.dataaccess.dao.common.commondao.BaseDaoFileImpl;
public class UserStatusDaoImpl extends BaseDaoFileImpl<UserStatus,Long, UserStatusDataImpl> implements UserStatusDao{

    @Override
    public Long getPK(UserStatus userStatus) {
        return userStatus.getId();
    }
}
