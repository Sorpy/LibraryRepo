package application.business.processor.userstatusprocessor;

import application.business.converter.userstatus.*;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.UserStatus;
import application.dataaccess.dao.userstatusdao.UserStatusDao;
import application.dataaccess.dao.userstatusdao.UserStatusDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserStatusProcessorImpl
        extends BaseProcessorImpl<UserStatusParam,UserStatus,UserStatusResult,Long,UserStatusDao,UserStatusParamConverter,UserStatusResultConverter>
        implements UserStatusProcessor{

}
