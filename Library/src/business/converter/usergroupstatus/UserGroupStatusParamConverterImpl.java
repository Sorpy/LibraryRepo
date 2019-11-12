package business.converter.usergroupstatus;

import data.entity.UserGroupStatus;
import dataaccess.dao.usergroupstatusdao.UserGroupStatusDao;
import dataaccess.dao.usergroupstatusdao.UserGroupStatusDaoImpl;

public class UserGroupStatusParamConverterImpl implements UserGroupStatusParamConverter {
    private UserGroupStatusDao userGroupStatusDao;

    public UserGroupStatusDao getUserGroupStatusDao() {
        return userGroupStatusDao;
    }

    public void setUserGroupStatusDao(UserGroupStatusDao userGroupStatusDao) {
        this.userGroupStatusDao = userGroupStatusDao;
    }

    @Override
    public UserGroupStatus convert(UserGroupStatusParam param) {
        return null;
    }
}
