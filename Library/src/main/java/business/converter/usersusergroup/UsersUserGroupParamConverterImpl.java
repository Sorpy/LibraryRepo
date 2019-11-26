package business.converter.usersusergroup;

import business.converter.IllegalConvertException;
import business.converter.common.BaseParamConverterImpl;
import data.entity.UsersUserGroup;
import dataaccess.dao.usersusergroupdao.UsersUserGroupDao;
import dataaccess.dao.usersusergroupdao.UsersUserGroupDaoImpl;

public class UsersUserGroupParamConverterImpl extends BaseParamConverterImpl<UsersUserGroupParam,UsersUserGroup> implements UsersUserGroupParamConverter {
    @Override
    public UsersUserGroup convert(UsersUserGroupParam param, UsersUserGroup oldEntity) {
        UsersUserGroup entity = null;
        if (oldEntity != null) {
            if (param.getId().equals(oldEntity.getId()) && param.getUnicode().equals(oldEntity.getCode())) {
                entity = oldEntity;
            } else {
                try {
                    throw new IllegalConvertException("Id and/or code do  not match");
                } catch (IllegalConvertException e) {
                    e.printStackTrace();
                }
            }
        } else {
            entity = new UsersUserGroup();
            entity.setId(param.getId());
            //entity.setCode(param.getUnicode());
        }
        entity = convertStandart(param, entity);
        return entity;
    }

    @Override
    public UsersUserGroup convertSpecific(UsersUserGroupParam param, UsersUserGroup entity) {
        return null;
    }
}

