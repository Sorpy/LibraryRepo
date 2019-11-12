package business.converter.usergroup;

import data.entity.UserGroup;

public class UserGroupResultConverterImpl implements UserGroupResultConverter{
    @Override
    public UserGroupResult convert(UserGroup param) {
        UserGroupResult userGroupResult = new UserGroupResult();
        userGroupResult.setUserGroupStatus(param.getUserGroupStatus());
        userGroupResult.setId(param.getId());
        return userGroupResult;
    }
}
