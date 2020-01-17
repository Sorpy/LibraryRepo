package application.presentation.service.usergroupstatusservice;

import application.business.converter.usergroupstatus.UserGroupStatusParam;
import application.business.converter.usergroupstatus.UserGroupStatusResult;
import application.business.processor.usergroupstatusprocessor.UserGroupStatusProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/UserGroupStatus")
public class UserGroupStatusServiceImpl
        extends BaseServiceImpl<UserGroupStatusParam,UserGroupStatusResult,Long,UserGroupStatusProcessor>
        implements UserGroupStatusService{

}
