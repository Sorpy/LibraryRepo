package application.business.processor.userstatusprocessor;

import application.business.converter.userstatus.*;
import application.data.entity.UserStatus;
import application.dataaccess.dao.userstatusdao.UserStatusDao;
import application.dataaccess.dao.userstatusdao.UserStatusDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserStatusProcessorImpl implements UserStatusProcessor{
    @Autowired
    private UserStatusDao userStatusDao;
    @Autowired
    private UserStatusParamConverter userStatusParamConverter;
    @Autowired
    private UserStatusResultConverter userStatusResultConverter;

    @Override
    public UserStatusResult create(UserStatusParam param) {
        return userStatusResultConverter.convert(userStatusDao
                .save(userStatusParamConverter
                        .convert(param,null)));
    }

    @Override
    public List<UserStatusResult> create(List<UserStatusParam> param) {
        List<UserStatus> userStatuses = new ArrayList<>();
        List<UserStatusResult> userStatusResults = new ArrayList<>();

        param.forEach(userStatusParam -> userStatuses
                .add(userStatusParamConverter
                        .convert(userStatusParam,null)));
        userStatusDao.save(userStatuses);
        userStatuses.forEach(user -> userStatusResults
                .add(userStatusResultConverter
                        .convert(user)));

        return userStatusResults;
    }

    @Override
    public void update(long id, UserStatusParam param) {
        UserStatus oldEntity = userStatusDao.find(id);
        if (oldEntity!=null){
            userStatusDao.delete(id);
            userStatusDao.update(userStatusParamConverter
                    .convert(param,oldEntity));
        }else System.out.println("No entity with id " + id + " found");
    }

    @Override
    public void update(List<UserStatusParam> param) {
        List<UserStatus> users = new ArrayList<>();
        param.forEach(userParam -> users
                .add(userStatusParamConverter
                        .convert(userParam,null)));
        userStatusDao.update(users);
    }

    @Override
    public void delete(long id) {
        userStatusDao.delete(id);
    }

    @Override
    public void delete(List<Long> idList) {
        userStatusDao.delete(idList);
    }

    @Override
    public UserStatusResult find(long id) {
        return userStatusResultConverter.convert(userStatusDao.find(id));
    }

    @Override
    public List<UserStatusResult> find() {
        List<UserStatusResult> userResults = new ArrayList<>();
        userStatusDao.find()
                .forEach(user -> userResults
                        .add(userStatusResultConverter
                                .convert(user)));
        return userResults;
    }
}
