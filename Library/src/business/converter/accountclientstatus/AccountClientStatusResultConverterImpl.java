package business.converter.accountclientstatus;

import business.converter.common.BaseResultConverterImpl;
import data.entity.AccountClientStatus;

public class AccountClientStatusResultConverterImpl extends BaseResultConverterImpl<AccountClientStatus,AccountClientStatusResult> implements AccountClientStatusResultConverter {
    @Override
    public AccountClientStatusResult convert(AccountClientStatus param) {
        AccountClientStatusResult accountClientStatusResult = new AccountClientStatusResult();
        accountClientStatusResult =convertStandart(param,accountClientStatusResult);
        return accountClientStatusResult;
    }

    @Override
    public AccountClientStatusResult convertSpecific(AccountClientStatus entity, AccountClientStatusResult result) {
        return null;
    }
}
