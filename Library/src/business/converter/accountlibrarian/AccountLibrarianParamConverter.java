package business.converter.accountlibrarian;

import business.converter.common.BaseParamConverter;
import data.entity.AccountLibrarian;

public interface AccountLibrarianParamConverter extends BaseParamConverter<AccountLibrarianParam,AccountLibrarian> {

    AccountLibrarian convert(AccountLibrarianParam param, AccountLibrarian oldEntity);
}
