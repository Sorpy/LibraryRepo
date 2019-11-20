package business.converter.userstatus;

import business.converter.common.BaseParamConverter;
import data.entity.UserStatus;

public interface UserStatusParamConverter extends BaseParamConverter<UserStatusParam,UserStatus> {
    UserStatus convert(UserStatusParam param, UserStatus oldEntity);

}
