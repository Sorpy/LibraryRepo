package application.business.converter.usergroupstatus;

import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.UserGroupStatus;
import org.springframework.stereotype.Component;

@Component
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

