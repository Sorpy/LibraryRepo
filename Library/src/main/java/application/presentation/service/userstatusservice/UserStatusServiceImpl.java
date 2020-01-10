package application.presentation.service.userstatusservice;

import application.business.converter.userstatus.UserStatusParam;
import application.business.converter.userstatus.UserStatusResult;
import application.business.processor.userstatusprocessor.UserStatusProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
@Component
public class UserStatusServiceImpl extends BaseServiceImpl<UserStatusParam,UserStatusResult,Long,UserStatusProcessor> implements UserStatusService{

}
