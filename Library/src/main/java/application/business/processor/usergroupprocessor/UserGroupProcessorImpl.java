package application.business.processor.usergroupprocessor;

import application.business.converter.usergroup.*;
import application.data.entity.UserGroup;
import application.dataaccess.dao.usergroupdao.UserGroupDao;
import application.dataaccess.dao.usergroupdao.UserGroupDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserGroupProcessorImpl implements UserGroupProcessor{
    @Autowired
    private UserGroupDao userGroupDao;
    @Autowired
    private UserGroupParamConverter userGroupParamConverter;
    @Autowired
    private UserGroupResultConverter userGroupResultConverter;

    @Override
    public UserGroupResult create(UserGroupParam param) {
        return userGroupResultConverter
                .convert(userGroupDao
                        .save(userGroupParamConverter
                                .convert(param,null)));
    }

    @Override
    public List<UserGroupResult> create(List<UserGroupParam> param) {
        List<UserGroup> userGroups = new ArrayList<>();
        List<UserGroupResult> userGroupResults = new ArrayList<>();

        param.forEach(userGroupParam -> userGroups
                .add(userGroupParamConverter
                        .convert(userGroupParam,null)));
        userGroupDao.save(userGroups);
        userGroups.forEach(userGroup -> userGroupResults
                .add(userGroupResultConverter
                        .convert(userGroup)));

        return userGroupResults;
    }

    @Override
    public void update(long id, UserGroupParam param) {
        UserGroup oldEntity = userGroupDao.find(id);
        if (oldEntity!=null){
            userGroupDao.delete(id);
            userGroupDao.update(userGroupParamConverter
                    .convert(param,oldEntity));
        }else System.out.println("No entity with id " + id + " found");
    }

    @Override
    public void update(List<UserGroupParam> param) {
        List<UserGroup> userGroups = new ArrayList<>();
        param.forEach(userGroupParam -> userGroups
                .add(userGroupParamConverter
                        .convert(userGroupParam,null)));
        userGroupDao.update(userGroups);
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
        return userGroupResultConverter
                .convert(userGroupDao
                        .find(id));
    }

    @Override
    public List<UserGroupResult> find() {
        List<UserGroupResult> userResults = new ArrayList<>();
        userGroupDao.find()
                .forEach(user -> userResults
                        .add(userGroupResultConverter
                                .convert(user)));
        return userResults;
    }
}
