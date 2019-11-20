package business.converter.user;

import business.converter.common.BaseParamConverter;
import data.entity.User;

public interface UserParamConverter extends BaseParamConverter<UserParam,User> {
    User convert(UserParam param, User oldEntity);
}
