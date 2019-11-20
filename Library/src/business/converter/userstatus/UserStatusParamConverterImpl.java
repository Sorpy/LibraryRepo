package business.converter.userstatus;

import business.converter.IllegalConvertException;
import business.converter.common.BaseParamConverterImpl;
import data.entity.UserStatus;
import dataaccess.dao.userstatusdao.UserStatusDao;
import dataaccess.dao.userstatusdao.UserStatusDaoImpl;

public class UserStatusParamConverterImpl extends BaseParamConverterImpl<UserStatusParam,UserStatus> implements UserStatusParamConverter {

    @Override
    public UserStatus convert(UserStatusParam param, UserStatus oldEntity) {
        UserStatus entity = null;
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
            entity = new UserStatus();
            entity.setId(param.getId());
            //entity.setCode(param.getUnicode());
        }
        entity = convertStandart(param, entity);
        return entity;
    }

    @Override
    public UserStatus convertSpecific(UserStatusParam param, UserStatus entity) {
        return null;
    }
}
