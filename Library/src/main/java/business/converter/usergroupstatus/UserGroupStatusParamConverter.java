package business.converter.usergroupstatus;

import business.converter.common.BaseParamConverter;
import data.entity.UserGroupStatus;

public interface UserGroupStatusParamConverter extends BaseParamConverter<UserGroupStatusParam,UserGroupStatus> {
    UserGroupStatus convert(UserGroupStatusParam param,UserGroupStatus oldEntity);
}
