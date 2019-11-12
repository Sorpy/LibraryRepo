package presentation.service.usersusergroupservice;

import business.converter.usersusergroup.UsersUserGroupParam;
import business.processor.usersusergroupprocessor.UsersUserGroupProcessor;
import business.processor.usersusergroupprocessor.UsersUserGroupProcessorImpl;
import data.common.APIResponse;

import java.util.List;

public class UsersUserGroupServiceImpl implements UsersUserGroupService{
    private UsersUserGroupProcessor usersUserGroupProcessor;

    public UsersUserGroupProcessor getUsersUserGroupProcessor() {
        return usersUserGroupProcessor;
    }

    public void setUsersUserGroupProcessor(UsersUserGroupProcessor usersUserGroupProcessor) {
        this.usersUserGroupProcessor = usersUserGroupProcessor;
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
    public APIResponse create(UsersUserGroupParam param) {
        return null;
    }

    @Override
    public APIResponse create(List<UsersUserGroupParam> param) {
        return null;
    }

    @Override
    public APIResponse update(long id, UsersUserGroupParam param) {
        return null;
    }

    @Override
    public APIResponse update(List<UsersUserGroupParam> param) {
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
    public void validateParameters(UsersUserGroupParam param) {

    }

    @Override
    public void validateParameters(List<UsersUserGroupParam> param) {

    }
}
