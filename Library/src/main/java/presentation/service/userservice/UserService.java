package presentation.service.userservice;

import business.converter.user.UserParam;
import data.common.APIResponse;

import java.util.List;

public interface UserService {
    APIResponse findByPK(long id);
    APIResponse listAll();

    APIResponse create(UserParam param);
    APIResponse create(List<UserParam> param);

    APIResponse update(long id, UserParam param);
    APIResponse update(List<UserParam> param);

    APIResponse deleteById(long id);
    APIResponse delete(List<Long> idList);

    void validateParameters(UserParam param);
    void validateParameters(List<UserParam> param);
}
