package application.business.converter.user;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserResultConverterImpl extends BaseResultConverterImpl<User,UserResult> implements UserResultConverter {


    @Override
    public void convertSpecific(User entity, UserResult result) {
        result.setUserStatusId(entity.getUserStatus().getId());
        result.setUserStatusName(entity.getUserStatus().getName());
    }

    @Override
    public UserResult getResult() {
        return new UserResult();
    }
}
