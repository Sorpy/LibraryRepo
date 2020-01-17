package application.presentation.service.userservice;

import application.business.converter.user.UserParam;
import application.business.converter.user.UserResult;
import application.business.processor.userprocessor.UserProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/User")
public class UserServiceImpl extends BaseServiceImpl<UserParam,UserResult,Long,UserProcessor> implements UserService{
}
