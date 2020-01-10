package application.presentation.service.usersusergroupservice;

import application.business.converter.usersusergroup.UsersUserGroupParam;
import application.business.converter.usersusergroup.UsersUserGroupResult;
import application.business.processor.usersusergroupprocessor.UsersUserGroupProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
@Component
public class UsersUserGroupServiceImpl extends BaseServiceImpl<UsersUserGroupParam,UsersUserGroupResult,Long,UsersUserGroupProcessor> implements UsersUserGroupService{

}
