package business.converter.usersusergroup;

import business.converter.common.BaseResultConverterImpl;
import data.entity.UsersUserGroup;

public class UsersUserGroupResultConverterImpl extends BaseResultConverterImpl<UsersUserGroup,UsersUserGroupResult> implements UsersUserGroupResultConverter {
    @Override
    public UsersUserGroupResult convert(UsersUserGroup param) {
        UsersUserGroupResult usersUserGroupResult = new UsersUserGroupResult();
        usersUserGroupResult = convertStandart(param,usersUserGroupResult);
        return usersUserGroupResult;
    }

    @Override
    public UsersUserGroupResult convertSpecific(UsersUserGroup entity, UsersUserGroupResult result) {
        return null;
    }
}
