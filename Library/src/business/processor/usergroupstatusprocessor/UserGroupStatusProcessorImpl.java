package business.processor.usergroupstatusprocessor;

import business.converter.usergroupstatus.*;
import data.entity.UserGroupStatus;
import dataaccess.dao.usergroupstatusdao.UserGroupStatusDao;
import dataaccess.dao.usergroupstatusdao.UserGroupStatusDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class UserGroupStatusProcessorImpl implements UserGroupStatusProcessor{
    private UserGroupStatusDao userGroupStatusDao = new UserGroupStatusDaoImpl();
    private UserGroupStatusParamConverter userGroupStatusParamConverter = new UserGroupStatusParamConverterImpl();
    private UserGroupStatusResultConverter userGroupStatusResultConverter = new UserGroupStatusResultConverterImpl();

    @Override
    public UserGroupStatusResult create(UserGroupStatusParam param) {
        return userGroupStatusResultConverter
                .convert(userGroupStatusDao
                        .save(userGroupStatusParamConverter
                                .convert(param,null)));
    }

    @Override
    public List<UserGroupStatusResult> create(List<UserGroupStatusParam> param) {
        List<UserGroupStatus> userGroupStatuses = new ArrayList<>();
        List<UserGroupStatusResult> userGroupStatusResults = new ArrayList<>();

        param.forEach(userGroupParam -> userGroupStatuses
                .add(userGroupStatusParamConverter
                        .convert(userGroupParam,null)));
        userGroupStatusDao.save(userGroupStatuses);
        userGroupStatuses.forEach(userGroup -> userGroupStatusResults
                .add(userGroupStatusResultConverter
                        .convert(userGroup)));

        return userGroupStatusResults;
    }

    @Override
    public void update(long id, UserGroupStatusParam param) {
        UserGroupStatus oldEntity = userGroupStatusDao.find(id);
        if (oldEntity!=null){
            userGroupStatusDao.delete(id);
            userGroupStatusDao.update(userGroupStatusParamConverter
                    .convert(param,oldEntity));
        }else System.out.println("No entity with id " + id + " found");
    }

    @Override
    public void update(List<UserGroupStatusParam> param) {
        List<UserGroupStatus> userGroupStatuses = new ArrayList<>();
        param.forEach(userGroupStatusParam -> userGroupStatuses
                .add(userGroupStatusParamConverter
                        .convert(userGroupStatusParam,null)));
        userGroupStatusDao.update(userGroupStatuses);
    }

    @Override
    public void delete(long id) {
        userGroupStatusDao.delete(id);
    }

    @Override
    public void delete(List<Long> idList) {
        userGroupStatusDao.delete(idList);
    }

    @Override
    public UserGroupStatusResult find(long id) {
        return userGroupStatusResultConverter
                .convert(userGroupStatusDao
                        .find(id));
    }

    @Override
    public List<UserGroupStatusResult> find() {
        List<UserGroupStatusResult> userGroupStatusResults = new ArrayList<>();
        userGroupStatusDao.find()
                .forEach(userGroupStatus -> userGroupStatusResults
                        .add(userGroupStatusResultConverter
                                .convert(userGroupStatus)));
        return userGroupStatusResults;
    }
}
