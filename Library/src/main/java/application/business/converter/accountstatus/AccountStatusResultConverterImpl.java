package application.business.converter.accountstatus;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.AccountStatus;
import org.springframework.stereotype.Component;

@Component
public class AccountStatusResultConverterImpl extends BaseResultConverterImpl<AccountStatus, AccountStatusResult> implements AccountStatusResultConverter {
    @Override
    public AccountStatusResult getResult() {
        return new AccountStatusResult();
    }


    @Override
    public void convertSpecific(AccountStatus entity, AccountStatusResult result) { }
}
