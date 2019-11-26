package presentation.service.usergroupservice;

import business.converter.usergroup.UserGroupParam;
import data.common.APIResponse;

import java.util.List;

public interface UserGroupService {
    APIResponse findByPK(long id);
    APIResponse listAll();

    APIResponse create(UserGroupParam param);
    APIResponse create(List<UserGroupParam> param);

    APIResponse update(long id, UserGroupParam param);
    APIResponse update(List<UserGroupParam> param);

    APIResponse deleteById(long id);
    APIResponse delete(List<Long> idList);

    void validateParameters(UserGroupParam param);
    void validateParameters(List<UserGroupParam> param);
}
