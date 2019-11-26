package business.processor.usergroupprocessor;

import business.converter.usergroup.UserGroupParam;
import business.converter.usergroup.UserGroupResult;
import business.converter.usersusergroup.UsersUserGroupParam;

import java.util.List;

public interface UserGroupProcessor {
    UserGroupResult create(UserGroupParam param);
    List<UserGroupResult> create(List<UserGroupParam> param);

    void update(long id,UserGroupParam param);
    void update(List<UserGroupParam> param);

    void delete(long id);
    void delete(List<Long> idList);

    UserGroupResult find(long id);
    List<UserGroupResult> find();
}
