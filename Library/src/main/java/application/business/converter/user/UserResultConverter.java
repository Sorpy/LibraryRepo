package application.business.converter.user;

import application.business.converter.common.BaseResultConverter;
import application.data.entity.User;

public interface UserResultConverter extends BaseResultConverter<User, UserResult> {

    UserResult convert(User param);
}
