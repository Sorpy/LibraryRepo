package business.converter.accountlibrarian;

import business.converter.common.BaseResultConverterImpl;
import data.entity.AccountLibrarian;

public class AccountLibrarianResultConverterImpl extends BaseResultConverterImpl<AccountLibrarian,AccountLibrarianResult>
        implements AccountLibrarianResultConverter {
    @Override
    public AccountLibrarianResult convert(AccountLibrarian param) {

        AccountLibrarianResult accountLibrarianResult = new AccountLibrarianResult();
        accountLibrarianResult = convertStandart(param, accountLibrarianResult);
        accountLibrarianResult = convertSpecific(param, accountLibrarianResult);
        return accountLibrarianResult;
    }

    @Override
    public AccountLibrarianResult convertSpecific(AccountLibrarian entity, AccountLibrarianResult result) {
        result.setUsername(entity.getUser().getUsername());
        result.setUserId(entity.getUser().getId());
        result.setAccountLibrarianStatusName(entity.getAccountLibrarianStatus().getName());
        result.setAccountLibrarianStatusId(entity.getAccountLibrarianStatus().getId());
        return result;

    }
}