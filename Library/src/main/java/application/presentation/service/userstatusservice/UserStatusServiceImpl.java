package application.presentation.service.userstatusservice;

import application.business.converter.userstatus.UserStatusParam;
import application.business.converter.userstatus.UserStatusResult;
import application.business.processor.userstatusprocessor.UserStatusProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/UserStatus")
public class UserStatusServiceImpl
        extends BaseServiceImpl<UserStatusParam,UserStatusResult,Long,UserStatusProcessor>
        implements UserStatusService{

}
