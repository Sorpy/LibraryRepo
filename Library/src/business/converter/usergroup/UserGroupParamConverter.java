package business.converter.usergroup;

import data.entity.UserGroup;

public interface UserGroupParamConverter {
    UserGroup convert(UserGroupParam param);
    UserGroup convert(UserGroupParam param, UserGroup oldEntity);
}
