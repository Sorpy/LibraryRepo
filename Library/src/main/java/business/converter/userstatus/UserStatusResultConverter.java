package business.converter.userstatus;

import business.converter.common.BaseResultConverter;
import data.entity.UserStatus;

public interface UserStatusResultConverter extends BaseResultConverter<UserStatus,UserStatusResult> {
    UserStatusResult convert(UserStatus param);
}
