package business.converter.usersusergroup;

import data.entity.UsersUserGroup;
import dataaccess.dao.usersusergroupdao.UsersUserGroupDao;
import dataaccess.dao.usersusergroupdao.UsersUserGroupDaoImpl;

public class UsersUserGroupParamConverterImpl implements UsersUserGroupParamConverter {
    private UsersUserGroupDao usersUserGroupDao;

    public UsersUserGroupDao getUsersUserGroupDao() {
        return usersUserGroupDao;
    }

    public void setUsersUserGroupDao(UsersUserGroupDao usersUserGroupDao) {
        this.usersUserGroupDao = usersUserGroupDao;
    }

    @Override
    public UsersUserGroup convert(UsersUserGroupParam param) {
        return null;
    }
}
