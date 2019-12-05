package application.business.converter.usergroup;

import application.business.converter.common.BaseResultConverter;
import application.data.entity.UserGroup;

public interface UserGroupResultConverter extends BaseResultConverter<UserGroup,UserGroupResult> {
    UserGroupResult convert(UserGroup param);
}
