package application.business.converter.accounttype;

import application.business.converter.common.BaseParamConverter;
import application.data.entity.AccountType;

public interface AccountTypeParamConverter extends BaseParamConverter<AccountTypeParam, AccountType> {

    AccountType convert (AccountTypeParam param ,AccountType oldEntity);
}
