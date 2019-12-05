package application.business.converter.account;

import application.business.converter.common.BaseParamConverter;
import application.data.entity.Account;

public interface AccountParamConverter extends BaseParamConverter<AccountParam,Account> {

    Account convert(AccountParam param, Account oldEntity);
}
