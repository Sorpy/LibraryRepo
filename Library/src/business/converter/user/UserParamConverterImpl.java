package business.converter.user;

import business.converter.IllegalConvertException;
import business.converter.common.BaseParamConverterImpl;
import data.entity.User;
import dataaccess.dao.userdao.UserDao;
import dataaccess.dao.userstatusdao.UserStatusDao;
import dataaccess.dao.userstatusdao.UserStatusDaoImpl;

public class UserParamConverterImpl extends BaseParamConverterImpl<UserParam,User> implements UserParamConverter {
    private UserStatusDao userStatusDao = new UserStatusDaoImpl();

    @Override
    public User convert(UserParam param, User oldEntity) {
        User entity = null;
        if (oldEntity != null) {
            if (param.getId().equals(oldEntity.getId())) {
                entity = oldEntity;
            } else {
                try {
                    throw new IllegalConvertException("Id and/or code do  not match");
                } catch (IllegalConvertException e) {
                    e.printStackTrace();
                }
            }
        } else {
            entity = new User();
            entity.setId(param.getId());
        }
        entity = convertStandart(param, entity);
        entity = convertSpecific(param,entity);
        return entity;
    }

    @Override
    public User convertSpecific(UserParam param, User entity) {
        entity.setUserStatus(userStatusDao.find(param.getUserStatusId()));
        return entity;
    }
}
