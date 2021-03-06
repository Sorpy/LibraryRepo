package business.converter.user;

import business.converter.common.BaseResultConverterImpl;
import data.entity.User;

public class UserResultConverterImpl extends BaseResultConverterImpl<User,UserResult> implements UserResultConverter {
    @Override
    public UserResult convert(User param) {
        UserResult userResult = new UserResult();
        userResult = convertStandart(param,userResult);
        userResult = convertSpecific(param,userResult);
        return userResult;
    }

    @Override
    public UserResult convertSpecific(User entity, UserResult result) {
        result.setUserStatusId(entity.getUserStatus().getId());
        result.setUserStatusName(entity.getUserStatus().getName());
        return null;
    }
}
