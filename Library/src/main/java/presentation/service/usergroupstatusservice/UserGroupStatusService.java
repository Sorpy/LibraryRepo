package presentation.service.usergroupstatusservice;

import business.converter.usergroupstatus.UserGroupStatusParam;
import data.common.APIResponse;

import java.util.List;

public interface UserGroupStatusService {
    APIResponse findByPK(Long id);
    APIResponse listAll();

    APIResponse create(UserGroupStatusParam param);
    APIResponse create(List<UserGroupStatusParam> param);

    APIResponse update(Long id, UserGroupStatusParam param);
    APIResponse update(List<UserGroupStatusParam> param);

    APIResponse deleteById(Long id);
    APIResponse delete(List<Long> idList);

    void validateParameters(UserGroupStatusParam param);
    void validateParameters(List<UserGroupStatusParam> param);
}
