package application.business.converter.accountstatus;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.AccountStatus;
import org.springframework.stereotype.Component;

@Component
public class AccountStatusResultConverterImpl extends BaseResultConverterImpl<AccountStatus, AccountStatusResult> implements AccountStatusResultConverter {
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
