package application.presentation.service.usergroupservice;

import application.business.converter.usergroup.UserGroupParam;
import application.business.converter.usergroup.UserGroupResult;
import application.business.processor.usergroupprocessor.UserGroupProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
@Component
public class UserGroupServiceImpl
        extends BaseServiceImpl<UserGroupParam,UserGroupResult,Long,UserGroupProcessor>
        implements UserGroupService{

}
