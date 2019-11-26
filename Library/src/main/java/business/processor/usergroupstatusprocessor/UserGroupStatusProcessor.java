package business.processor.usergroupstatusprocessor;

import business.converter.usergroupstatus.UserGroupStatusParam;
import business.converter.usergroupstatus.UserGroupStatusResult;

import java.util.List;

public interface UserGroupStatusProcessor {
    UserGroupStatusResult create(UserGroupStatusParam param);
    List<UserGroupStatusResult> create(List<UserGroupStatusParam> param);

    void update(long id,UserGroupStatusParam param);
    void update(List<UserGroupStatusParam> param);

    void delete(long id);
    void delete(List<Long> idList);

    UserGroupStatusResult find(long id);
    List<UserGroupStatusResult> find();
}
