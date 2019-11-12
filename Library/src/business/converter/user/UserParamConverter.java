package business.converter.user;

import data.entity.User;

public interface UserParamConverter {
    User convert(UserParam param) ;
    User convert(UserParam param, User oldEntity);
}
