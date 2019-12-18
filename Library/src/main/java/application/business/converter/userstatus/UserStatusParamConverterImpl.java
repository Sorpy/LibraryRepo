package application.business.converter.userstatus;

import application.data.entity.UserStatus;
import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import org.springframework.stereotype.Component;

@Component
public class UserStatusParamConverterImpl extends BaseParamConverterImpl<UserStatusParam, UserStatus> implements UserStatusParamConverter {



    @Override
    public void convertSpecific(UserStatusParam param, UserStatus entity) {
    }

    @Override
    public UserStatus getEntity(UserStatusParam param) {
        UserStatus userStatus = new UserStatus();
        userStatus.setCode(param.getCode());
        userStatus.setId(param.getId());
        return null;
    }
}
