package application.business.processor.usersusergroupprocessor;

import application.business.converter.usersusergroup.UsersUserGroupParam;
import application.business.converter.usersusergroup.UsersUserGroupResult;

import java.util.List;

public interface UsersUserGroupProcessor {
    UsersUserGroupResult create(UsersUserGroupParam param);
    List<UsersUserGroupResult> create(List<UsersUserGroupParam> param);

    void update(long id,UsersUserGroupParam param);
    void update(List<UsersUserGroupParam> param);

    void delete(long id);
    void delete(List<Long> idList);

    UsersUserGroupResult find(long id);
    List<UsersUserGroupResult> find();
}
