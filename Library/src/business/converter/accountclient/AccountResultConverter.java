package business.converter.accountclient;

import business.converter.common.BaseResultConverter;
import data.entity.Account;

public interface AccountResultConverter extends BaseResultConverter<Account,AccountResult> {
    AccountResult convert(Account param) throws IllegalAccessException;
}
