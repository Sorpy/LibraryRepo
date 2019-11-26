package business.converter.userstatus;

import business.converter.common.BaseResultConverterImpl;
import data.entity.UserStatus;

public class UserStatusResultConverterImpl extends BaseResultConverterImpl<UserStatus,UserStatusResult> implements UserStatusResultConverter {
    @Override
    public UserStatusResult convert(UserStatus param) {
        UserStatusResult userStatusResult = new UserStatusResult();
        userStatusResult = convertStandart(param,userStatusResult);
        return userStatusResult;
    }

    @Override
    public UserStatusResult convertSpecific(UserStatus entity, UserStatusResult result) {
        return null;
    }
}
