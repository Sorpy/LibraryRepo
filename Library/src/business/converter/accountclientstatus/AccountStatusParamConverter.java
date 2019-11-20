package business.converter.accountclientstatus;

import business.converter.common.BaseParamConverter;
import data.entity.AccountStatus;

public interface AccountStatusParamConverter extends BaseParamConverter<AccountStatusParam,AccountStatus> {

    AccountStatus convert(AccountStatusParam param, AccountStatus oldEntity);
}
