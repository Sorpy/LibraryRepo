package application.business.processor.userprocessor;

import application.business.converter.user.UserParam;
import application.business.converter.user.UserResult;
import application.business.processor.common.BaseProcessor;

public interface UserProcessor extends BaseProcessor<UserParam,UserResult,Long> {

    public UserResult getUser(String username);

}
