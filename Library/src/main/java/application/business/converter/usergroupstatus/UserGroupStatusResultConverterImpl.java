package application.business.converter.usergroupstatus;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.UserGroupStatus;
import org.springframework.stereotype.Component;

@Component
public class UserGroupStatusResultConverterImpl
        extends BaseResultConverterImpl<UserGroupStatus,UserGroupStatusResult>
        implements UserGroupStatusResultConverter {



    @Override
    public void convertSpecific(UserGroupStatus entity, UserGroupStatusResult result) {
    }

    @Override
    public UserGroupStatusResult getResult() {
        return new UserGroupStatusResult();
    }
}
