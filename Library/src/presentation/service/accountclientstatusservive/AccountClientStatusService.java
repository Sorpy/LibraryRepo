package presentation.service.accountclientstatusservive;

import business.converter.accountclientstatus.AccountClientStatusParam;
import data.common.APIResponse;

import java.util.List;

public interface AccountClientStatusService {
    APIResponse findByPK(long id);
    APIResponse listAll();

    APIResponse create(AccountClientStatusParam param);
    APIResponse create(List<AccountClientStatusParam> param);

    APIResponse update(long id, AccountClientStatusParam param);
    APIResponse update(List<AccountClientStatusParam> param);

    APIResponse deleteById(long id);
    APIResponse delete(List<Long> idList);

    void validateParameters(AccountClientStatusParam param);
    void validateParameters(List<AccountClientStatusParam> param);
}
