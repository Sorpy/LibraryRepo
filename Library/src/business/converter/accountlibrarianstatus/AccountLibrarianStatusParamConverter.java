package business.converter.accountlibrarianstatus;

import business.converter.common.BaseParamConverter;
import data.entity.AccountLibrarianStatus;

public interface AccountLibrarianStatusParamConverter extends BaseParamConverter<AccountLibrarianStatusParam,AccountLibrarianStatus> {

    AccountLibrarianStatus convert(AccountLibrarianStatusParam param, AccountLibrarianStatus oldEntity);
}
