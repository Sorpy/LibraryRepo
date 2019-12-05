package application.business.converter.usergroupstatus;

import application.business.converter.common.BaseParamConverter;
import application.data.entity.UserGroupStatus;

public interface UserGroupStatusParamConverter extends BaseParamConverter<UserGroupStatusParam,UserGroupStatus> {
    UserGroupStatus convert(UserGroupStatusParam param,UserGroupStatus oldEntity);
}
