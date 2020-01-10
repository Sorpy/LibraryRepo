package application.business.processor.usergroupprocessor;

import application.business.converter.usergroup.UserGroupParam;
import application.business.converter.usergroup.UserGroupParamConverter;
import application.business.converter.usergroup.UserGroupResult;
import application.business.converter.usergroup.UserGroupResultConverter;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.UserGroup;
import application.dataaccess.dao.usergroupdao.UserGroupDao;
import org.springframework.stereotype.Component;
@Component
public class UserGroupProcessorImpl
    extends BaseProcessorImpl<UserGroupParam,UserGroup,UserGroupResult,Long,UserGroupDao,UserGroupParamConverter,UserGroupResultConverter>
        implements UserGroupProcessor{

    @Override
    public Long getPK(UserGroupParam ent) {
        return  ent.getId();

    }
}
