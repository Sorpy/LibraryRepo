package application.business.converter.user;

import application.business.converter.common.BaseParamConverter;
import application.data.entity.User;

public interface UserParamConverter extends BaseParamConverter<UserParam,User> {
    User convert(UserParam param, User oldEntity);
}
