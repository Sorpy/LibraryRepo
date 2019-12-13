package application.business.converter.accounttype;

import application.business.converter.common.BaseResultConverter;
import application.data.entity.AccountType;

public interface AccountTypeResultConverter extends BaseResultConverter<AccountType,AccountTypeResult> {
    AccountTypeResult convert(AccountType param);
}
