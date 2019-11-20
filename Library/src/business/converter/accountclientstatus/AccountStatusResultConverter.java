package business.converter.accountclientstatus;

import business.converter.common.BaseResultConverter;
import data.entity.AccountStatus;

public interface AccountStatusResultConverter extends BaseResultConverter<AccountStatus,AccountStatusResult> {
    AccountStatusResult convert(AccountStatus param);
}
