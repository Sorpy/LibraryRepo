package application.business.converter.accounttype;

import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.AccountType;
import org.springframework.stereotype.Component;

@Component
public class AccountTypeParamConverterImpl extends BaseParamConverterImpl<AccountTypeParam,AccountType>implements AccountTypeParamConverter {

    @Override
    public void convertSpecific(AccountTypeParam param, AccountType entity) { }

    @Override
    public AccountType getEntity(AccountTypeParam param) {
        AccountType accountType = new AccountType();
        accountType.setId(param.getId());
        accountType.setCode(param.getCode());
        return accountType;
    }
}