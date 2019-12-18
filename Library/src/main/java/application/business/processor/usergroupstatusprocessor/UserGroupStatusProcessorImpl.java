package application.business.processor.usergroupstatusprocessor;

import application.business.converter.usergroupstatus.*;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.UserGroupStatus;
import application.dataaccess.dao.usergroupdao.UserGroupDao;
import application.dataaccess.dao.usergroupstatusdao.UserGroupStatusDao;
import application.dataaccess.dao.usergroupstatusdao.UserGroupStatusDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserGroupStatusProcessorImpl
    extends BaseProcessorImpl<UserGroupStatusParam, UserGroupStatus, UserGroupStatusResult, Long, UserGroupStatusDao, UserGroupStatusParamConverter,UserGroupStatusResultConverterImpl>
        implements UserGroupStatusProcessor{

}
