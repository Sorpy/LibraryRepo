package business.converter.userstatus;

import data.entity.UserStatus;
import dataaccess.dao.userstatusdao.UserStatusDao;
import dataaccess.dao.userstatusdao.UserStatusDaoImpl;

public class UserStatusParamConverterImpl implements UserStatusParamConverter {
    private UserStatusDao userStatusDao;

    public UserStatusDao getUserStatusDao() {
        return userStatusDao;
    }

    public void setUserStatusDao(UserStatusDao userStatusDao) {
        this.userStatusDao = userStatusDao;
    }

    @Override
    public UserStatus convert(UserStatusParam param) {
        return null;
    }
}
