package business.converter.usergroup;

import business.converter.common.BaseResultConverter;
import data.entity.UserGroup;

public interface UserGroupResultConverter extends BaseResultConverter<UserGroup,UserGroupResult> {
    UserGroupResult convert(UserGroup param);
}
