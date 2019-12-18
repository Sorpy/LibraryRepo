package application.business.processor.usergroupstatusprocessor;

import application.business.converter.usergroupstatus.UserGroupStatusParam;
import application.business.converter.usergroupstatus.UserGroupStatusResult;
import application.business.processor.common.BaseProcessor;
import application.data.entity.UserGroupStatus;

import java.util.List;

public interface UserGroupStatusProcessor extends BaseProcessor<UserGroupStatusParam,UserGroupStatusResult,Long> {

}
