package business.converter.usersusergroup;

import business.converter.common.BaseResultConverter;
import data.entity.UsersUserGroup;

public interface UsersUserGroupResultConverter extends BaseResultConverter<UsersUserGroup,UsersUserGroupResult> {

    UsersUserGroupResult convert(UsersUserGroup param);
}
