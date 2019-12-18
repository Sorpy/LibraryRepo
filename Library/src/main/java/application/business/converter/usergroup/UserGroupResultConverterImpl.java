package application.business.converter.usergroup;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.UserGroup;
import org.springframework.stereotype.Component;

@Component
public class UserGroupResultConverterImpl extends BaseResultConverterImpl<UserGroup,UserGroupResult> implements UserGroupResultConverter{


    @Override
    public void convertSpecific(UserGroup entity, UserGroupResult result) {
        result.setUserGroupStatusId(entity.getUserGroupStatus().getId());
        result.setUserGroupStatusName(entity.getUserGroupStatus().getName());
    }

    @Override
    public UserGroupResult getResult() {
        return new UserGroupResult();
    }
}
