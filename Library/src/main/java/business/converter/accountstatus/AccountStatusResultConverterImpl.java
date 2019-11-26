package business.converter.accountstatus;

import business.converter.common.BaseResultConverterImpl;
import data.entity.AccountStatus;

public class AccountStatusResultConverterImpl extends BaseResultConverterImpl<AccountStatus,AccountStatusResult> implements AccountStatusResultConverter {
    @Override
    public AccountStatusResult convert(AccountStatus param) {
        AccountStatusResult accountStatusResult = new AccountStatusResult();
        accountStatusResult =convertStandart(param, accountStatusResult);
        return accountStatusResult;
    }

    @Override
    public AccountStatusResult convertSpecific(AccountStatus entity, AccountStatusResult result) {
        return null;
    }
}
