package presentation.service.accountclientstatusservive;

import business.converter.accountclientstatus.AccountStatusParam;
import data.common.APIResponse;

import java.util.List;

public interface AccountStatusService {
    APIResponse findByPK(long id);
    APIResponse listAll();

    APIResponse create(AccountStatusParam param);
    APIResponse create(List<AccountStatusParam> param);

    APIResponse update(long id, AccountStatusParam param);
    APIResponse update(List<AccountStatusParam> param);

    APIResponse deleteById(long id);
    APIResponse delete(List<Long> idList);

    void validateParameters(AccountStatusParam param);
    void validateParameters(List<AccountStatusParam> param);
}
