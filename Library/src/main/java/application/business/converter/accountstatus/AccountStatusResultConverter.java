package application.business.converter.accountstatus;

import application.business.converter.common.BaseResultConverter;
import application.data.entity.AccountStatus;

public interface AccountStatusResultConverter extends BaseResultConverter<AccountStatus, AccountStatusResult> {
    AccountStatusResult convert(AccountStatus param);
}
