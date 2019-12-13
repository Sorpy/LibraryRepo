package application.presentation.service.accounttype;

import application.business.converter.accounttype.AccountTypeParam;
import application.data.common.APIResponse;

import java.util.List;

public interface AccountTypeService {
    APIResponse findByPK(long id);

    APIResponse listAll();

    APIResponse create(AccountTypeParam param);

    APIResponse create(List<AccountTypeParam> param);

    APIResponse update(long id, AccountTypeParam param);

    APIResponse update(List<AccountTypeParam> param);

    APIResponse deleteById(long id);

    APIResponse delete(List<Long> idList);

    void validateParameters(AccountTypeParam param);

    void validateParameters(List<AccountTypeParam> param);
}
