package business.converter.user;

import data.entity.User;
import dataaccess.dao.userdao.UserDao;

public class UserParamConverterImpl implements UserParamConverter {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User convert(UserParam param) {
        User user = new User();
        user.setUsername(param.getUsername());
        user.setPassword(param.getPassword());
        user.setUserStatus(param.getUserStatus());
        user.setId(param.getId());
        return user;
    }
    @Override
    public User convert(UserParam param, User oldEntity){
        User entity = null;
        if(oldEntity!=null){
            entity = oldEntity;
        } else {
            entity = new User();
        }
        entity.setUserStatus(param.getUserStatus());
        entity.setPassword(param.getPassword());
        entity.setUsername(param.getUsername());
        return entity;
    }
}
