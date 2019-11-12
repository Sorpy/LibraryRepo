package business.processor.usersusergroupprocessor;

import business.converter.usersusergroup.UsersUserGroupParam;
import business.converter.usersusergroup.UsersUserGroupResult;

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
