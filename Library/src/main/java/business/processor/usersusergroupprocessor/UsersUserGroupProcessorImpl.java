package business.processor.usersusergroupprocessor;

import business.converter.usersusergroup.*;
import data.entity.UsersUserGroup;
import dataaccess.dao.usersusergroupdao.UsersUserGroupDao;
import dataaccess.dao.usersusergroupdao.UsersUserGroupDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class UsersUserGroupProcessorImpl implements UsersUserGroupProcessor{
    private UsersUserGroupDao usersUserGroupDao = new UsersUserGroupDaoImpl();
    private UsersUserGroupParamConverter usersUserGroupParamConverter =  new UsersUserGroupParamConverterImpl();
    private UsersUserGroupResultConverter usersUserGroupResultConverter = new UsersUserGroupResultConverterImpl();

    @Override
    public UsersUserGroupResult create(UsersUserGroupParam param) {
        return usersUserGroupResultConverter.convert(usersUserGroupDao
                .save(usersUserGroupParamConverter
                        .convert(param,null)));
    }

    @Override
    public List<UsersUserGroupResult> create(List<UsersUserGroupParam> param) {
        List<UsersUserGroup> usersUserGroups = new ArrayList<>();
        List<UsersUserGroupResult> usersUserGroupResults = new ArrayList<>();

        param.forEach(userStatusParam -> usersUserGroups
                .add(usersUserGroupParamConverter
                        .convert(userStatusParam,null)));
        usersUserGroupDao.save(usersUserGroups);
        usersUserGroups.forEach(user -> usersUserGroupResults
                .add(usersUserGroupResultConverter
                        .convert(user)));

        return usersUserGroupResults;
    }

    @Override
    public void update(long id, UsersUserGroupParam param) {
        UsersUserGroup oldEntity = usersUserGroupDao.find(id);
        if (oldEntity!=null){
            usersUserGroupDao.delete(id);
            usersUserGroupDao.update(usersUserGroupParamConverter
                    .convert(param,oldEntity));
        }else System.out.println("No entity with id " + id + " found");
    }

    @Override
    public void update(List<UsersUserGroupParam> param) {
        List<UsersUserGroup> usersUserGroups = new ArrayList<>();
        param.forEach(usersUserGroupParam -> usersUserGroups
                .add(usersUserGroupParamConverter
                        .convert(usersUserGroupParam,null)));
        usersUserGroupDao.update(usersUserGroups);
    }

    @Override
    public void delete(long id) {
        usersUserGroupDao.delete(id);
    }

    @Override
    public void delete(List<Long> idList) {
        usersUserGroupDao.delete(idList);
    }

    @Override
    public UsersUserGroupResult find(long id) {
        return usersUserGroupResultConverter.convert(usersUserGroupDao.find(id));
    }

    @Override
    public List<UsersUserGroupResult> find() {
        List<UsersUserGroupResult> userResults = new ArrayList<>();
        usersUserGroupDao.find()
                .forEach(user -> userResults
                        .add(usersUserGroupResultConverter
                                .convert(user)));
        return userResults;
    }
}
