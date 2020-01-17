package application.presentation.service.usersusergroupservice;

import application.business.converter.usersusergroup.UsersUserGroupParam;
import application.business.converter.usersusergroup.UsersUserGroupResult;
import application.business.processor.usersusergroupprocessor.UsersUserGroupProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/UsersUserGroup")
public class UsersUserGroupServiceImpl extends BaseServiceImpl<UsersUserGroupParam,UsersUserGroupResult,Long,UsersUserGroupProcessor> implements UsersUserGroupService{

}
