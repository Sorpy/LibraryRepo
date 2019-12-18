package application.business.processor.userprocessor;

import application.business.converter.user.*;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.User;
import application.dataaccess.dao.userdao.UserDao;
import application.dataaccess.dao.userdao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserProcessorImpl extends BaseProcessorImpl<UserParam,User, UserResult,Long,UserDao,UserParamConverter,UserResultConverter> implements UserProcessor{

}
