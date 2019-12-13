package application.business.processor.accounttypeprocessor;

import application.business.converter.accounttype.AccountTypeParam;
import application.business.converter.accounttype.AccountTypeResult;

import java.util.List;

public interface AccountTypeProcessor {
    AccountTypeResult create(AccountTypeParam param);
    List<AccountTypeResult> create(List<AccountTypeParam> param);

    void update(Long id,AccountTypeParam param);
    void update(List<AccountTypeParam> param);

    void delete(Long id);
    void delete(List<Long> idList);

    AccountTypeResult find(Long id);
    List<AccountTypeResult> find();
}
