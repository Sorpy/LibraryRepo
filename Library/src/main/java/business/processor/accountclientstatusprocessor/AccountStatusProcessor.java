package business.processor.accountclientstatusprocessor;

import business.converter.accountstatus.AccountStatusParam;
import business.converter.accountstatus.AccountStatusResult;

import java.util.List;

public interface AccountStatusProcessor {
    AccountStatusResult create(AccountStatusParam param);
    List<AccountStatusResult> create(List<AccountStatusParam> param);

    void update(Long id,AccountStatusParam param);
    void update(List<AccountStatusParam> param);

    void delete(Long id);
    void delete(List<Long> idList);

    AccountStatusResult find(Long id);
    List<AccountStatusResult> find();
}
