package application.business.converter.accounttype;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.AccountType;
import org.springframework.stereotype.Component;

@Component
public class AccountTypeResultConverterImpl extends BaseResultConverterImpl<AccountType,AccountTypeResult> implements AccountTypeResultConverter {

    @Override
    public AccountTypeResult getResult() {
        return new AccountTypeResult();
    }

    @Override
    public void convertSpecific(AccountType entity, AccountTypeResult result) { }
}



