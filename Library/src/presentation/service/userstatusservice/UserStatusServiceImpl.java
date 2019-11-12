package presentation.service.userstatusservice;

import business.converter.userstatus.UserStatusParam;
import business.processor.userstatusprocessor.UserStatusProcessor;
import business.processor.userstatusprocessor.UserStatusProcessorImpl;
import data.common.APIResponse;

import java.util.List;

public class UserStatusServiceImpl implements UserStatusService{
    private UserStatusProcessor userStatusProcessor;

    public UserStatusProcessor  getUserStatusProcessor() {
        return userStatusProcessor;
    }

    public void setUserStatusProcessor(UserStatusProcessor userStatusProcessor) {
        this.userStatusProcessor = userStatusProcessor;
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
    public APIResponse create(UserStatusParam param) {
        return null;
    }

    @Override
    public APIResponse create(List<UserStatusParam> param) {
        return null;
    }

    @Override
    public APIResponse update(long id, UserStatusParam param) {
        return null;
    }

    @Override
    public APIResponse update(List<UserStatusParam> param) {
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
    public void validateParameters(UserStatusParam param) {

    }

    @Override
    public void validateParameters(List<UserStatusParam> param) {

    }
}
