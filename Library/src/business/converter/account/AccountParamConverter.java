package business.converter.account;

import business.converter.common.BaseParamConverter;
import data.entity.Account;

public interface AccountParamConverter extends BaseParamConverter<AccountParam,Account> {

    Account convert(AccountParam param, Account oldEntity);
}
