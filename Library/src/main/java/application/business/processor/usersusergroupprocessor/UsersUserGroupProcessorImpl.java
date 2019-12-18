package application.business.processor.usersusergroupprocessor;

import application.business.converter.usersusergroup.*;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.UsersUserGroup;
import application.dataaccess.dao.usersusergroupdao.UsersUserGroupDao;
import application.dataaccess.dao.usersusergroupdao.UsersUserGroupDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UsersUserGroupProcessorImpl
    extends BaseProcessorImpl<UsersUserGroupParam,UsersUserGroup,UsersUserGroupResult,Long,UsersUserGroupDao,UsersUserGroupParamConverter,UsersUserGroupResultConverter>
        implements UsersUserGroupProcessor{

}
