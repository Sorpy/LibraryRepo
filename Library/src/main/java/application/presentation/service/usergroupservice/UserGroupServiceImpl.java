package application.presentation.service.usergroupservice;

import application.business.converter.usergroup.UserGroupParam;
import application.business.converter.usergroup.UserGroupResult;
import application.business.processor.usergroupprocessor.UserGroupProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/UserGroup")
public class UserGroupServiceImpl
        extends BaseServiceImpl<UserGroupParam,UserGroupResult,Long,UserGroupProcessor>
        implements UserGroupService{

}
