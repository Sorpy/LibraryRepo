package application.business.processor.userprocessor;

import application.business.converter.user.*;
import application.data.entity.User;
import application.dataaccess.dao.userdao.UserDao;
import application.dataaccess.dao.userdao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserProcessorImpl implements UserProcessor{
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserParamConverter userParamConverter;
    @Autowired
    private UserResultConverter userResultConverter;

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
