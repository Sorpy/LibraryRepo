package application.business.converter.usergroup;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.UserGroup;
import org.springframework.stereotype.Component;

@Component
public class UserGroupResultConverterImpl extends BaseResultConverterImpl<UserGroup,UserGroupResult> implements UserGroupResultConverter{
    @Override
    public UserGroupResult convert(UserGroup param) {
        UserGroupResult userGroupResult = new UserGroupResult();
        userGroupResult = convertStandart(param,userGroupResult);
        userGroupResult = convertSpecific(param,userGroupResult);
        return userGroupResult;
    }

    @Override
    public UserGroupResult convertSpecific(UserGroup entity, UserGroupResult result) {
        result.setUserGroupStatusId(entity.getUserGroupStatus().getId());
        result.setUserGroupStatusName(entity.getUserGroupStatus().getName());
        return result;
    }
}
