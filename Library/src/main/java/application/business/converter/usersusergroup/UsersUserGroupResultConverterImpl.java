package application.business.converter.usersusergroup;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.UsersUserGroup;
import org.springframework.stereotype.Component;

@Component
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
