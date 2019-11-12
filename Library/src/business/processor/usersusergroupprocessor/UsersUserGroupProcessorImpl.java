package business.processor.usersusergroupprocessor;

import business.converter.usersusergroup.*;
import dataaccess.dao.usersusergroupdao.UsersUserGroupDao;
import dataaccess.dao.usersusergroupdao.UsersUserGroupDaoImpl;

import java.util.List;

public class UsersUserGroupProcessorImpl implements UsersUserGroupProcessor{
    private UsersUserGroupDao usersUserGroupDao;
    private UsersUserGroupParamConverter usersUserGroupParamConverter;
    private UsersUserGroupResultConverter usersUserGroupResultConverter;

    public UsersUserGroupDao getUsersUserGroupDao() {
        return usersUserGroupDao;
    }

    public void setUsersUserGroupDao(UsersUserGroupDao usersUserGroupDao) {
        this.usersUserGroupDao = usersUserGroupDao;
    }

    public UsersUserGroupParamConverter getUsersUserGroupParamConverter() {
        return usersUserGroupParamConverter;
    }

    public void setUsersUserGroupParamConverter(UsersUserGroupParamConverter usersUserGroupParamConverter) {
        this.usersUserGroupParamConverter = usersUserGroupParamConverter;
    }

    public UsersUserGroupResultConverter getUsersUserGroupResultConverter() {
        return usersUserGroupResultConverter;
    }

    public void setUsersUserGroupResultConverter(UsersUserGroupResultConverter usersUserGroupResultConverter) {
        this.usersUserGroupResultConverter = usersUserGroupResultConverter;
    }

    @Override
    public UsersUserGroupResult create(UsersUserGroupParam param) {
        return null;
    }

    @Override
    public List<UsersUserGroupResult> create(List<UsersUserGroupParam> param) {
        return null;
    }

    @Override
    public void update(long id, UsersUserGroupParam param) {

    }

    @Override
    public void update(List<UsersUserGroupParam> param) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void delete(List<Long> idList) {

    }

    @Override
    public UsersUserGroupResult find(long id) {
        return null;
    }

    @Override
    public List<UsersUserGroupResult> find() {
        return null;
    }
}
