package application.business.converter.userstatus;

import application.data.entity.UserStatus;
import application.business.converter.common.BaseResultConverterImpl;
import org.springframework.stereotype.Component;

@Component
public class UserStatusResultConverterImpl
        extends BaseResultConverterImpl<UserStatus,UserStatusResult>
        implements UserStatusResultConverter {

    @Override
    public void convertSpecific(UserStatus entity, UserStatusResult result) {
    }

    @Override
    public UserStatusResult getResult() {
        return new UserStatusResult();
    }
}
