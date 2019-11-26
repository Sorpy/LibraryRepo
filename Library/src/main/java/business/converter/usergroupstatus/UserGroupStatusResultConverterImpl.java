package business.converter.usergroupstatus;

import business.converter.common.BaseResultConverterImpl;
import data.entity.UserGroupStatus;

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
