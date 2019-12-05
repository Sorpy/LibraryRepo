package application.business.converter.usergroup;

import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.UserGroup;
import application.dataaccess.dao.usergroupstatusdao.UserGroupStatusDao;
import application.dataaccess.dao.usergroupstatusdao.UserGroupStatusDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserGroupParamConverterImpl extends BaseParamConverterImpl<UserGroupParam,UserGroup> implements UserGroupParamConverter {
    @Autowired
    private UserGroupStatusDao userGroupStatusDao;

    @Override
    public UserGroup convert(UserGroupParam param, UserGroup oldEntity){
        UserGroup entity = null;
        if(oldEntity!=null)
        {
            if(param.getId().equals(oldEntity.getId())){
                entity = oldEntity;
            }
            else {
                try {
                    throw new IllegalConvertException("Id and/or code do  not match");
                } catch (IllegalConvertException e) {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            entity = new UserGroup();
            entity.setId(param.getId());
            //entity.setCode(param.getUnicode());
        }
        entity = convertStandart(param,entity);
        entity = convertSpecific(param,entity);
        return entity;
    }

    @Override
    public UserGroup convertSpecific(UserGroupParam param, UserGroup entity) {
        entity.setUserGroupStatus(userGroupStatusDao.find(param.getUserGroupStatusId()));
        return entity;
    }
}
