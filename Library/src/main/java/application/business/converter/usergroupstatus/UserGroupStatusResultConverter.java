package application.business.converter.usergroupstatus;

import application.business.converter.common.BaseParamConverter;
import application.data.entity.UserGroupStatus;

public interface UserGroupStatusResultConverter extends BaseParamConverter<UserGroupStatus,UserGroupStatusResult> {
    UserGroupStatusResult convert(UserGroupStatus param);
}
