package business.converter.usergroupstatus;

import business.converter.IllegalConvertException;
import business.converter.common.BaseParamConverterImpl;
import data.entity.UserGroupStatus;
import dataaccess.dao.usergroupstatusdao.UserGroupStatusDao;
import dataaccess.dao.usergroupstatusdao.UserGroupStatusDaoImpl;

public class UserGroupStatusParamConverterImpl extends BaseParamConverterImpl<UserGroupStatusParam,UserGroupStatus> implements UserGroupStatusParamConverter {
    @Override
    public UserGroupStatus convert(UserGroupStatusParam param, UserGroupStatus oldEntity) {
        UserGroupStatus entity = null;
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
            entity = new UserGroupStatus();
            entity.setId(param.getId());
            //entity.setCode(param.getUnicode());
        }
        entity = convertStandart(param, entity);
        return entity;
    }

    @Override
    public UserGroupStatus convertSpecific(UserGroupStatusParam param, UserGroupStatus entity) {
        return null;
    }
}

