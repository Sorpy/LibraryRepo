package application.business.converter.usersusergroup;

import application.business.converter.common.BaseParamConverter;
import application.data.entity.UsersUserGroup;

public interface UsersUserGroupParamConverter extends BaseParamConverter<UsersUserGroupParam,UsersUserGroup> {
    UsersUserGroup convert(UsersUserGroupParam param,UsersUserGroup oldEntity);
}
