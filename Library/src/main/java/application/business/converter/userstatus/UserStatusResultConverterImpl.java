package application.business.converter.userstatus;

import application.data.entity.UserStatus;
import application.business.converter.common.BaseResultConverterImpl;
import org.springframework.stereotype.Component;

@Component
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
