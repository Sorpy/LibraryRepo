package application.business.converter.accounttype;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.AccountType;
import org.springframework.stereotype.Component;

@Component
public class AccountTypeResultConverterImpl extends BaseResultConverterImpl<AccountType,AccountTypeResult> implements AccountTypeResultConverter {

    @Override
    public AccountTypeResult convert(AccountType param) {
        AccountTypeResult accountTypeResult = new AccountTypeResult();
        accountTypeResult = convertStandart(param, accountTypeResult);
        return accountTypeResult;
    }

    @Override
    public AccountTypeResult convertSpecific(AccountType entity, AccountTypeResult result) {
        return null;
    }
}



