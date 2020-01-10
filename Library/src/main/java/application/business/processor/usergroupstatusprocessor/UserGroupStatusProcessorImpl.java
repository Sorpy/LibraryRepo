package application.business.processor.usergroupstatusprocessor;

import application.business.converter.usergroupstatus.UserGroupStatusParam;
import application.business.converter.usergroupstatus.UserGroupStatusParamConverter;
import application.business.converter.usergroupstatus.UserGroupStatusResult;
import application.business.converter.usergroupstatus.UserGroupStatusResultConverterImpl;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.UserGroupStatus;
import application.dataaccess.dao.usergroupstatusdao.UserGroupStatusDao;
import org.springframework.stereotype.Component;
@Component
public class UserGroupStatusProcessorImpl
    extends BaseProcessorImpl<UserGroupStatusParam, UserGroupStatus, UserGroupStatusResult, Long, UserGroupStatusDao, UserGroupStatusParamConverter,UserGroupStatusResultConverterImpl>
        implements UserGroupStatusProcessor{

    @Override
    public Long getPK(UserGroupStatusParam ent) {
        return  ent.getId();

    }
}
