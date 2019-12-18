package application.business.converter.usergroupstatus;

import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.UserGroup;
import application.data.entity.UserGroupStatus;
import org.springframework.stereotype.Component;

@Component
public class UserGroupStatusParamConverterImpl
        extends BaseParamConverterImpl<UserGroupStatusParam,UserGroupStatus>
        implements UserGroupStatusParamConverter {


    @Override
    public void convertSpecific(UserGroupStatusParam param, UserGroupStatus entity) {
    }

    @Override
    public UserGroupStatus getEntity(UserGroupStatusParam param) {
        UserGroupStatus userGroupStatus = new UserGroupStatus();
        userGroupStatus.setCode(param.getCode());
        userGroupStatus.setId(param.getId());
        return userGroupStatus;
    }
}

