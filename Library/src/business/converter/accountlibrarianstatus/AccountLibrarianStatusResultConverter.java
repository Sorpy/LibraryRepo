package business.converter.accountlibrarianstatus;

import business.converter.common.BaseResultConverter;
import data.entity.AccountLibrarianStatus;

public interface AccountLibrarianStatusResultConverter extends BaseResultConverter<AccountLibrarianStatus,AccountLibrarianStatusResult> {
    AccountLibrarianStatusResult convert(AccountLibrarianStatus param);
}
