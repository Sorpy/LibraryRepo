package application.business.converter.userstatus;

import application.data.entity.UserStatus;
import application.business.converter.common.BaseParamConverter;

public interface UserStatusParamConverter extends BaseParamConverter<UserStatusParam, UserStatus> {
    UserStatus convert(UserStatusParam param, UserStatus oldEntity);

}
