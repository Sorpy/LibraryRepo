package application.business.processor.usergroupprocessor;

import application.business.converter.usergroup.UserGroupParam;
import application.business.converter.usergroup.UserGroupResult;
import application.business.processor.common.BaseProcessor;
import application.data.entity.UserGroup;

import java.util.List;

public interface UserGroupProcessor extends BaseProcessor<UserGroupParam,UserGroupResult, Long> {

}
