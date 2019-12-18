package application.business.converter.usersusergroup;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.UsersUserGroup;
import org.springframework.stereotype.Component;

@Component
public class UsersUserGroupResultConverterImpl
        extends BaseResultConverterImpl<UsersUserGroup,UsersUserGroupResult>
        implements UsersUserGroupResultConverter {

    @Override
    public void convertSpecific(UsersUserGroup entity, UsersUserGroupResult result) {
    }

    @Override
    public UsersUserGroupResult getResult() {
        return new UsersUserGroupResult();
    }
}
