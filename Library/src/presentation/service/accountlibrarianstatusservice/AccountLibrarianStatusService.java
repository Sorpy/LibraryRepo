package presentation.service.accountlibrarianstatusservice;

import business.converter.accountlibrarianstatus.AccountLibrarianStatusParam;
import data.common.APIResponse;

import java.util.List;

public interface AccountLibrarianStatusService {
    APIResponse findByPK(long id);
    APIResponse listAll();

    APIResponse create(AccountLibrarianStatusParam param);
    APIResponse create(List<AccountLibrarianStatusParam> param);

    APIResponse update(long id, AccountLibrarianStatusParam param);
    APIResponse update(List<AccountLibrarianStatusParam> param);

    APIResponse deleteById(long id);
    APIResponse delete(List<Long> idList);

    void validateParameters(AccountLibrarianStatusParam param);
    void validateParameters(List<AccountLibrarianStatusParam> param);
}
