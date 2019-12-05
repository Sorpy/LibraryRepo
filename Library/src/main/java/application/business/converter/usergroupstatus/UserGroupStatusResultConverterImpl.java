package application.business.converter.usergroupstatus;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.UserGroupStatus;
import org.springframework.stereotype.Component;

@Component
public class UserGroupStatusResultConverterImpl extends BaseResultConverterImpl<UserGroupStatus,UserGroupStatusResult> implements UserGroupStatusResultConverter {
    @Override
    public UserGroupStatusResult convert(UserGroupStatus param) {
        UserGroupStatusResult userGroupStatusResult = new UserGroupStatusResult();
        userGroupStatusResult = convertStandart(param,userGroupStatusResult);
        return userGroupStatusResult;
    }

    @Override
    public UserGroupStatusResult convertSpecific(UserGroupStatus entity, UserGroupStatusResult result) {
        return null;
    }
}
