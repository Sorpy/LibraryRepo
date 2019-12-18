package application.business.converter.usersusergroup;

import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.UsersUserGroup;
import org.springframework.stereotype.Component;

@Component
public class UsersUserGroupParamConverterImpl extends BaseParamConverterImpl<UsersUserGroupParam,UsersUserGroup> implements UsersUserGroupParamConverter {


    @Override
    public void convertSpecific(UsersUserGroupParam param, UsersUserGroup entity) {
    }

    @Override
    public UsersUserGroup getEntity(UsersUserGroupParam param) {
        UsersUserGroup usersUserGroup = new UsersUserGroup();
        usersUserGroup.setId(param.getId());
        usersUserGroup.setCode(param.getCode());
        return null;
    }
}

