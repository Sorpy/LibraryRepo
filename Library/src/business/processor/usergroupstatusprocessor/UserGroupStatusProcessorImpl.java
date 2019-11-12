package business.processor.usergroupstatusprocessor;

import business.converter.usergroupstatus.*;
import dataaccess.dao.usergroupstatusdao.UserGroupStatusDao;
import dataaccess.dao.usergroupstatusdao.UserGroupStatusDaoImpl;

import java.util.List;

public class UserGroupStatusProcessorImpl implements UserGroupStatusProcessor{
    private UserGroupStatusDao userGroupStatusDao;
    private UserGroupStatusParamConverter userGroupStatusParamConverter;
    private UserGroupStatusResultConverter userGroupStatusResultConverter;

    public UserGroupStatusDao getUserGroupStatusDao() {
        return userGroupStatusDao;
    }

    public void setUserGroupStatusDao(UserGroupStatusDao userGroupStatusDao) {
        this.userGroupStatusDao = userGroupStatusDao;
    }

    public UserGroupStatusParamConverter getUserGroupStatusParamConverter() {
        return userGroupStatusParamConverter;
    }

    public void setUserGroupStatusParamConverter(UserGroupStatusParamConverter userGroupStatusParamConverter) {
        this.userGroupStatusParamConverter = userGroupStatusParamConverter;
    }

    public UserGroupStatusResultConverter getUserGroupStatusResultConverter() {
        return userGroupStatusResultConverter;
    }

    public void setUserGroupStatusResultConverter(UserGroupStatusResultConverter userGroupStatusResultConverter) {
        this.userGroupStatusResultConverter = userGroupStatusResultConverter;
    }

    @Override
    public UserGroupStatusResult create(UserGroupStatusParam param) {
        return null;
    }

    @Override
    public List<UserGroupStatusResult> create(List<UserGroupStatusParam> param) {
        return null;
    }

    @Override
    public void update(long id, UserGroupStatusParam param) {

    }

    @Override
    public void update(List<UserGroupStatusParam> param) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void delete(List<Long> idList) {

    }

    @Override
    public UserGroupStatusResult find(long id) {
        return null;
    }

    @Override
    public List<UserGroupStatusResult> find() {
        return null;
    }
}
