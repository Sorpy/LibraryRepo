package business.converter.usersusergroup;

import business.converter.common.BaseParamConverter;
import data.entity.UsersUserGroup;

public interface UsersUserGroupParamConverter extends BaseParamConverter<UsersUserGroupParam,UsersUserGroup> {
    UsersUserGroup convert(UsersUserGroupParam param,UsersUserGroup oldEntity);
}
