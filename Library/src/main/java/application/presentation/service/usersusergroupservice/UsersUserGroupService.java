package application.presentation.service.usersusergroupservice;

import application.business.converter.usersusergroup.UsersUserGroupParam;
import application.data.common.APIResponse;

import java.util.List;

public interface UsersUserGroupService {
    APIResponse findByPK(long id);
    APIResponse listAll();

    APIResponse create(UsersUserGroupParam param);
    APIResponse create(List<UsersUserGroupParam> param);

    APIResponse update(long id, UsersUserGroupParam param);
    APIResponse update(List<UsersUserGroupParam> param);

    APIResponse deleteById(long id);
    APIResponse delete(List<Long> idList);

    void validateParameters(UsersUserGroupParam param);
    void validateParameters(List<UsersUserGroupParam> param);
}
