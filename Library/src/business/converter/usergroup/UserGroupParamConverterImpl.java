package business.converter.usergroup;

import data.entity.UserGroup;
import dataaccess.dao.usergroupdao.UserGroupDao;

public class UserGroupParamConverterImpl implements UserGroupParamConverter {
    private UserGroupDao userGroupDao;

    public UserGroupDao getUserGroupDao() {
        return userGroupDao;
    }

    public void setUserGroupDao(UserGroupDao userGroupDao) {
        this.userGroupDao = userGroupDao;
    }

    @Override
    public UserGroup convert(UserGroupParam param) {

        UserGroup userGroup = new UserGroup();
        userGroup.setId(param.getId());
        userGroup.setUserGroupStatus(param.getUserGroupStatus());
        return userGroup;
    }
    @Override
    public UserGroup convert(UserGroupParam param, UserGroup oldEntity) {
        UserGroup entity = null;
        if (oldEntity != null) {
            entity = oldEntity;
        } else {
            entity = new UserGroup();
        }
        entity.setUserGroupStatus(param.getUserGroupStatus());
        return entity;
    }
}
