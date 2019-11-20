package business.converter.usergroup;

import business.converter.IllegalConvertException;
import business.converter.common.BaseParamConverterImpl;
import data.entity.UserGroup;
import dataaccess.dao.usergroupdao.UserGroupDao;
import dataaccess.dao.usergroupdao.UserGroupDaoImpl;
import dataaccess.dao.usergroupstatusdao.UserGroupStatusDao;
import dataaccess.dao.usergroupstatusdao.UserGroupStatusDaoImpl;

public class UserGroupParamConverterImpl extends BaseParamConverterImpl<UserGroupParam,UserGroup> implements UserGroupParamConverter {
    private UserGroupStatusDao userGroupStatusDao = new UserGroupStatusDaoImpl();

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
