package business.converter.accountclientstatus;

import business.converter.common.BaseParamConverter;
import business.converter.common.BaseResultConverter;
import data.entity.AccountClientStatus;

public interface AccountClientStatusParamConverter extends BaseParamConverter<AccountClientStatusParam,AccountClientStatus> {

    AccountClientStatus convert(AccountClientStatusParam param, AccountClientStatus oldEntity);
}
