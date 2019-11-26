package business.processor.userprocessor;

import business.converter.user.UserParam;
import business.converter.user.UserResult;

import java.util.List;

public interface UserProcessor {
    UserResult create(UserParam param);
    List<UserResult> create(List<UserParam> param);

    void update(long id,UserParam param);
    void update(List<UserParam> param);

    void delete(long id);
    void delete(List<Long> idList);

    UserResult find(long id);
    List<UserResult> find();
}
