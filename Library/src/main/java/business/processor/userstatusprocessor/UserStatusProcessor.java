package business.processor.userstatusprocessor;

import business.converter.userstatus.UserStatusParam;
import business.converter.userstatus.UserStatusResult;

import java.util.List;

public interface UserStatusProcessor {
    UserStatusResult create(UserStatusParam param);
    List<UserStatusResult> create(List<UserStatusParam> param);

    void update(long id,UserStatusParam param);
    void update(List<UserStatusParam> param);

    void delete(long id);
    void delete(List<Long> idList);

    UserStatusResult find(long id);
    List<UserStatusResult> find();
}
