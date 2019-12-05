package application.business.converter.userstatus;

import application.data.entity.UserStatus;
import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import org.springframework.stereotype.Component;

@Component
public class UserStatusParamConverterImpl extends BaseParamConverterImpl<UserStatusParam, UserStatus> implements UserStatusParamConverter {

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
