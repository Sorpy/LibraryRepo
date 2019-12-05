package application.business.converter.user;

import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.User;
import application.dataaccess.dao.userstatusdao.UserStatusDao;
import application.dataaccess.dao.userstatusdao.UserStatusDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserParamConverterImpl extends BaseParamConverterImpl<UserParam,User> implements UserParamConverter {
    @Autowired
    private UserStatusDao userStatusDao;

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
