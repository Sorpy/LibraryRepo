package presentation.service.usergroupstatusservice;

import business.converter.usergroupstatus.UserGroupStatusParam;
import business.processor.usergroupstatusprocessor.UserGroupStatusProcessor;
import business.processor.usergroupstatusprocessor.UserGroupStatusProcessorImpl;
import data.common.APIResponse;

import java.util.List;

public class UserGroupStatusServiceImpl implements UserGroupStatusService{
    private UserGroupStatusProcessor userGroupStatusProcessor;

    public UserGroupStatusProcessor getUserGroupStatusProcessor() {
        return userGroupStatusProcessor;
    }

    public void setUserGroupStatusProcessor(UserGroupStatusProcessor userGroupStatusProcessor) {
        this.userGroupStatusProcessor = userGroupStatusProcessor;
    }

    @Override
    public APIResponse findByPK(long id) {
        return null;
    }

    @Override
    public APIResponse listAll() {
        return null;
    }

    @Override
    public APIResponse create(UserGroupStatusParam param) {
        return null;
    }

    @Override
    public APIResponse create(List<UserGroupStatusParam> param) {
        return null;
    }

    @Override
    public APIResponse update(long id, UserGroupStatusParam param) {
        return null;
    }

    @Override
    public APIResponse update(List<UserGroupStatusParam> param) {
        return null;
    }

    @Override
    public APIResponse deleteById(long id) {
        return null;
    }

    @Override
    public APIResponse delete(List<Long> idList) {
        return null;
    }

    @Override
    public void validateParameters(UserGroupStatusParam param) {

    }

    @Override
    public void validateParameters(List<UserGroupStatusParam> param) {

    }
}
