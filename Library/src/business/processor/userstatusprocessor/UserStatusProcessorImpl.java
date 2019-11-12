package business.processor.userstatusprocessor;

import business.converter.userstatus.*;
import dataaccess.dao.userstatusdao.UserStatusDao;
import dataaccess.dao.userstatusdao.UserStatusDaoImpl;

import java.util.List;

public class UserStatusProcessorImpl implements UserStatusProcessor{
    private UserStatusDao userStatusDao;
    private UserStatusParamConverter userStatusParamConverter;
    private UserStatusResultConverter userStatusResultConverter;

    public UserStatusDao getUserStatusDao() {
        return userStatusDao;
    }

    public void setUserStatusDao(UserStatusDao userStatusDao) {
        this.userStatusDao = userStatusDao;
    }

    public UserStatusParamConverter getUserStatusParamConverter() {
        return userStatusParamConverter;
    }

    public void setUserStatusParamConverter(UserStatusParamConverter userStatusParamConverter) {
        this.userStatusParamConverter = userStatusParamConverter;
    }

    public UserStatusResultConverter getUserStatusResultConverter() {
        return userStatusResultConverter;
    }

    public void setUserStatusResultConverter(UserStatusResultConverter userStatusResultConverter) {
        this.userStatusResultConverter = userStatusResultConverter;
    }

    @Override
    public UserStatusResult create(UserStatusParam param) {
        return null;
    }

    @Override
    public List<UserStatusResult> create(List<UserStatusParam> param) {
        return null;
    }

    @Override
    public void update(long id, UserStatusParam param) {

    }

    @Override
    public void update(List<UserStatusParam> param) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void delete(List<Long> idList) {

    }

    @Override
    public UserStatusResult find(long id) {
        return null;
    }

    @Override
    public List<UserStatusResult> find() {
        return null;
    }
}
