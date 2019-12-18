package application.business.processor.userstatusprocessor;

import application.business.converter.userstatus.UserStatusParam;
import application.business.converter.userstatus.UserStatusResult;
import application.business.processor.common.BaseProcessor;
import application.data.entity.UserStatus;

import java.util.List;

public interface UserStatusProcessor extends BaseProcessor<UserStatusParam, UserStatusResult,Long> {

}
