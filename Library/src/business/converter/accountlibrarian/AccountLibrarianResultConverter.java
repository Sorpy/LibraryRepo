package business.converter.accountlibrarian;

import business.converter.common.BaseResultConverter;
import data.entity.AccountLibrarian;

public interface AccountLibrarianResultConverter extends BaseResultConverter<AccountLibrarian,AccountLibrarianResult> {
    AccountLibrarianResult convert(AccountLibrarian param);
}
