package business.converter.usergroupstatus;

import business.converter.common.BaseParamConverter;
import data.entity.UserGroupStatus;

public interface UserGroupStatusResultConverter extends BaseParamConverter<UserGroupStatus,UserGroupStatusResult> {
    UserGroupStatusResult convert(UserGroupStatus param);
}
