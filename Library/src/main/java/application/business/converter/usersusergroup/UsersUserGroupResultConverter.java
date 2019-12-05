package application.business.converter.usersusergroup;

import application.business.converter.common.BaseResultConverter;
import application.data.entity.UsersUserGroup;

public interface UsersUserGroupResultConverter extends BaseResultConverter<UsersUserGroup,UsersUserGroupResult> {

    UsersUserGroupResult convert(UsersUserGroup param);
}
