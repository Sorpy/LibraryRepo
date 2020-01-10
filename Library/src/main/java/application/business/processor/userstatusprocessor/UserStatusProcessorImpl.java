package application.business.processor.userstatusprocessor;

import application.business.converter.userstatus.UserStatusParam;
import application.business.converter.userstatus.UserStatusParamConverter;
import application.business.converter.userstatus.UserStatusResult;
import application.business.converter.userstatus.UserStatusResultConverter;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.UserStatus;
import application.dataaccess.dao.userstatusdao.UserStatusDao;
import org.springframework.stereotype.Component;
@Component
public class UserStatusProcessorImpl
        extends BaseProcessorImpl<UserStatusParam,UserStatus,UserStatusResult,Long,UserStatusDao,UserStatusParamConverter,UserStatusResultConverter>
        implements UserStatusProcessor{

    @Override
    public Long getPK(UserStatusParam ent) {
        return  ent.getId();

    }
}
