package business.converter.accountclient;

import business.converter.common.BaseResultConverter;
import data.entity.AccountClient;

public interface AccountClientResultConverter extends BaseResultConverter<AccountClient,AccountClientResult> {
    AccountClientResult convert(AccountClient param) throws IllegalAccessException;
}
