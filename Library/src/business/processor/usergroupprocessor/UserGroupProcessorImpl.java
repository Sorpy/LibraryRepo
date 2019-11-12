package business.processor.usergroupprocessor;

import business.converter.usergroup.*;
import business.converter.usersusergroup.UsersUserGroupParam;
import data.entity.UserGroup;
import dataaccess.dao.usergroupdao.UserGroupDao;
import dataaccess.dao.usergroupdao.UserGroupDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class UserGroupProcessorImpl implements UserGroupProcessor{
    private UserGroupDao userGroupDao;
    private UserGroupParamConverter userGroupParamConverter;
    private UserGroupResultConverter userGroupResultConverter;

    public UserGroupDao getUserGroupDao() {
        return userGroupDao;
    }

    public void setUserGroupDao(UserGroupDao userGroupDao) {
        this.userGroupDao = userGroupDao;
    }

    public UserGroupParamConverter getUserGroupParamConverter() {
        return userGroupParamConverter;
    }

    public void setUserGroupParamConverter(UserGroupParamConverter userGroupParamConverter) {
        this.userGroupParamConverter = userGroupParamConverter;
    }

    public UserGroupResultConverter getUserGroupResultConverter() {
        return userGroupResultConverter;
    }

    public void setUserGroupResultConverter(UserGroupResultConverter userGroupResultConverter) {
        this.userGroupResultConverter = userGroupResultConverter;
    }

    @Override
    public UserGroupResult create(UserGroupParam param) {
        return userGroupResultConverter.convert(userGroupDao.save(userGroupParamConverter.convert(param)));
    }

    @Override
    public List<UserGroupResult> create(List<UserGroupParam> param) {
        List<UserGroup> userGroups = new ArrayList<>();
        List<UserGroupResult> userGroupResults = new ArrayList<>();

        param.forEach(userGroupParam -> userGroups.add(userGroupParamConverter.convert(userGroupParam)));
        userGroupDao.save(userGroups);
        userGroups.forEach(userGroup -> userGroupResults.add(userGroupResultConverter.convert(userGroup)));

        return userGroupResults;
    }

    @Override
    public void update(long id, UserGroupParam param) {
        UserGroup oldEntity = userGroupDao.find(id);
        if (oldEntity!=null){
            userGroupDao.delete(id);
            userGroupDao.update(userGroupParamConverter.convert(param,oldEntity));
        }else System.out.println("No entity with id " + id + " found");
    }

    @Override
    public void update(List<UserGroupParam> param) {

    }

    @Override
    public void delete(long id) {
        userGroupDao.delete(id);
    }

    @Override
    public void delete(List<Long> idList) {
        userGroupDao.delete(idList);
    }

    @Override
    public UserGroupResult find(long id) {
        return userGroupResultConverter.convert(userGroupDao.find(id));
    }

    @Override
    public List<UserGroupResult> find() {
        List<UserGroupResult> userResults = new ArrayList<>();
        userGroupDao.find()
                .forEach(user -> userResults.add(userGroupResultConverter.convert(user)));
        return userResults;
    }
}
