package business.converter.usergroup;

import business.converter.common.BaseParamConverter;
import data.entity.UserGroup;

public interface UserGroupParamConverter extends BaseParamConverter<UserGroupParam,UserGroup> {
    UserGroup convert(UserGroupParam param, UserGroup oldEntity);
}
