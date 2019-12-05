package application.business.converter.account;

import application.business.converter.common.BaseResultConverter;
import application.data.entity.Account;

public interface AccountResultConverter extends BaseResultConverter<Account,AccountResult> {
    AccountResult convert(Account param) throws IllegalAccessException;
}
