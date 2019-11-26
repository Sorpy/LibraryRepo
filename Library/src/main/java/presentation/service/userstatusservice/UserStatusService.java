package presentation.service.userstatusservice;

import business.converter.userstatus.UserStatusParam;
import data.common.APIResponse;

import java.util.List;

public interface UserStatusService {
    APIResponse findByPK(long id);
    APIResponse listAll();

    APIResponse create(UserStatusParam param);
    APIResponse create(List<UserStatusParam> param);

    APIResponse update(long id, UserStatusParam param);
    APIResponse update(List<UserStatusParam> param);

    APIResponse deleteById(long id);
    APIResponse delete(List<Long> idList);

    void validateParameters(UserStatusParam param);
    void validateParameters(List<UserStatusParam> param);
}
