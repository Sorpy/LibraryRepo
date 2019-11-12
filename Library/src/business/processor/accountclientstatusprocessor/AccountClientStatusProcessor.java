package business.processor.accountclientstatusprocessor;

import business.converter.accountclientstatus.AccountClientStatusParam;
import business.converter.accountclientstatus.AccountClientStatusResult;

import java.util.List;

public interface AccountClientStatusProcessor {
    AccountClientStatusResult create(AccountClientStatusParam param);
    List<AccountClientStatusResult> create(List<AccountClientStatusParam> param);

    void update(Long id,AccountClientStatusParam param);
    void update(List<AccountClientStatusParam> param);

    void delete(Long id);
    void delete(List<Long> idList);

    AccountClientStatusResult find(Long id);
    List<AccountClientStatusResult> find();
}
