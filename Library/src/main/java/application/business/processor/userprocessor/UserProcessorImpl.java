package application.business.processor.userprocessor;

import application.business.converter.user.UserParam;
import application.business.converter.user.UserParamConverter;
import application.business.converter.user.UserResult;
import application.business.converter.user.UserResultConverter;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.User;
import application.dataaccess.dao.userdao.UserDao;
import org.springframework.stereotype.Component;
@Component
public class UserProcessorImpl extends BaseProcessorImpl<UserParam,User, UserResult,Long,UserDao,UserParamConverter,UserResultConverter> implements UserProcessor{

    @Override
    public Long getPK(UserParam ent) {
        return  ent.getId();

    }
}
