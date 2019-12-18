package application.business.converter.usergroup;

import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.UserGroup;
import application.dataaccess.dao.usergroupstatusdao.UserGroupStatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserGroupParamConverterImpl extends BaseParamConverterImpl<UserGroupParam,UserGroup> implements UserGroupParamConverter {
    @Autowired
    private UserGroupStatusDao userGroupStatusDao;



    @Override
    public void convertSpecific(UserGroupParam param, UserGroup entity) {
        entity.setUserGroupStatus(userGroupStatusDao.find(param.getUserGroupStatusId()));
    }

    @Override
    public UserGroup getEntity(UserGroupParam param) {
        UserGroup userGroup = new UserGroup();
        userGroup.setId(param.getId());
        return userGroup;
    }
}
