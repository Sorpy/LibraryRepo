package business.converter.user;

import business.converter.common.BaseResultConverter;
import data.entity.User;

public interface UserResultConverter extends BaseResultConverter<User,UserResult> {

    UserResult convert(User param);
}
