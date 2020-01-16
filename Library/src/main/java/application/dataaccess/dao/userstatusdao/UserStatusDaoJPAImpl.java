package application.dataaccess.dao.userstatusdao;

import application.data.entity.UserStatus;
import application.dataaccess.dao.common.commondao.BaseDaoJPAImpl;

public class UserStatusDaoJPAImpl extends BaseDaoJPAImpl<UserStatus,Long> implements UserStatusDao {
    @Override
    public Class<UserStatus> getMyType() {
        return UserStatus.class;
    }
}
