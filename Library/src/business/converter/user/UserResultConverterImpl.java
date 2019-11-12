package business.converter.user;

import data.entity.User;

public class UserResultConverterImpl implements UserResultConverter {
    @Override
    public UserResult convert(User param) {
        UserResult userResult = new UserResult();
        userResult.setPassword(param.getPassword());
        userResult.setUsername(param.getUsername());
        userResult.setUserStatus(param.getUserStatus());
        userResult.setId(param.getId());
        return userResult;
    }
}
