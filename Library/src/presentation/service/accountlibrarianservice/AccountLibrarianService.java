package presentation.service.accountlibrarianservice;

import business.converter.accountlibrarian.AccountLibrarianParam;
import data.common.APIResponse;

import java.util.List;

public interface AccountLibrarianService {
    APIResponse findByPK(Long id);
    APIResponse findByName(String name);
    APIResponse listAll();

    APIResponse create(AccountLibrarianParam param);
    APIResponse create(List<AccountLibrarianParam> param);

    APIResponse update(Long id, AccountLibrarianParam param);
    APIResponse update(List<AccountLibrarianParam> param);

    APIResponse deleteById(Long id);
    APIResponse delete(List<Long> idList);

    void validateParameters(AccountLibrarianParam param);
    void validateParameters(List<AccountLibrarianParam> param);
}
