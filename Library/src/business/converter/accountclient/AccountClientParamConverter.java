package business.converter.accountclient;

import business.converter.common.BaseParamConverter;
import data.entity.AccountClient;

public interface AccountClientParamConverter extends BaseParamConverter<AccountClientParam,AccountClient> {

    AccountClient convert(AccountClientParam param, AccountClient oldEntity);
}
