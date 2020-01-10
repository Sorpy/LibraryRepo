package application.presentation.service.usergroupstatusservice;

import application.business.converter.usergroupstatus.UserGroupStatusParam;
import application.business.converter.usergroupstatus.UserGroupStatusResult;
import application.business.processor.usergroupstatusprocessor.UserGroupStatusProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
@Component
public class UserGroupStatusServiceImpl
        extends BaseServiceImpl<UserGroupStatusParam,UserGroupStatusResult,Long,UserGroupStatusProcessor>
        implements UserGroupStatusService{

}
