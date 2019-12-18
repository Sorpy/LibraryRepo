package application.business.processor.usergroupprocessor;

import application.business.converter.usergroup.*;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.UserGroup;
import application.dataaccess.dao.usergroupdao.UserGroupDao;
import application.dataaccess.dao.usergroupdao.UserGroupDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserGroupProcessorImpl
    extends BaseProcessorImpl<UserGroupParam,UserGroup,UserGroupResult,Long,UserGroupDao,UserGroupParamConverter,UserGroupResultConverter>
        implements UserGroupProcessor{

}
