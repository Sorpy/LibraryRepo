package business.converter.accountclientstatus;

import business.converter.common.BaseResultConverter;
import data.entity.AccountClientStatus;

public interface AccountClientStatusResultConverter extends BaseResultConverter<AccountClientStatus,AccountClientStatusResult> {
    AccountClientStatusResult convert(AccountClientStatus param);
}
