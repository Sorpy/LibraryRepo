package application.business.processor.usersusergroupprocessor;

import application.business.converter.usersusergroup.UsersUserGroupParam;
import application.business.converter.usersusergroup.UsersUserGroupParamConverter;
import application.business.converter.usersusergroup.UsersUserGroupResult;
import application.business.converter.usersusergroup.UsersUserGroupResultConverter;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.UsersUserGroup;
import application.dataaccess.dao.usersusergroupdao.UsersUserGroupDao;
import org.springframework.stereotype.Component;
@Component
public class UsersUserGroupProcessorImpl
    extends BaseProcessorImpl<UsersUserGroupParam,
        UsersUserGroup,
        UsersUserGroupResult,
        Long,
        UsersUserGroupDao,
        UsersUserGroupParamConverter,
        UsersUserGroupResultConverter>
        implements UsersUserGroupProcessor{

    @Override
    public Long getPK(UsersUserGroupParam ent) {
        return  ent.getId();

    }
}
