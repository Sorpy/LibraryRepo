package business.processor.userprocessor;

import business.converter.user.*;
import data.entity.User;
import dataaccess.dao.userdao.UserDao;
import dataaccess.dao.userdao.UserDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class UserProcessorImpl implements UserProcessor{
    private UserDao userDao = new UserDaoImpl();
    private UserParamConverter userParamConverter = new UserParamConverterImpl();
    private UserResultConverter userResultConverter = new UserResultConverterImpl();

    @Override
    public UserResult create(UserParam param) {
        return userResultConverter.convert(userDao
                .save(userParamConverter
                        .convert(param,null)));
    }

    @Override
    public List<UserResult> create(List<UserParam> param) {
        List<User> users = new ArrayList<>();
        List<UserResult> userResults = new ArrayList<>();

        param.forEach(userParam -> users
                .add(userParamConverter
                        .convert(userParam,null)));
        userDao.save(users);
        users.forEach(user -> userResults
                .add(userResultConverter
                        .convert(user)));

        return userResults;
    }

    @Override
    public void update(long id, UserParam param) {
        User oldEntity = userDao.find(id);
        if (oldEntity!=null){
            userDao.delete(id);
            userDao.update(userParamConverter
                    .convert(param,oldEntity));
        }else System.out.println("No entity with id " + id + " found");
    }

    @Override
    public void update(List<UserParam> param) {
        List<User> users = new ArrayList<>();
        param.forEach(userParam -> users
                .add(userParamConverter
                        .convert(userParam,null)));
        userDao.update(users);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public void delete(List<Long> idList) {
        userDao.delete(idList);
    }

    @Override
    public UserResult find(long id) {
        return userResultConverter.convert(userDao.find(id));
    }

    @Override
    public List<UserResult> find() {
        List<UserResult> userResults = new ArrayList<>();
        userDao.find()
                .forEach(user -> userResults
                        .add(userResultConverter
                                .convert(user)));
        return userResults;
    }
}
