package business.converter.accountlibrarianstatus;

import business.converter.common.BaseResultConverterImpl;
import data.entity.AccountLibrarianStatus;

public class AccountLibrarianStatusResultConverterImpl extends BaseResultConverterImpl<AccountLibrarianStatus,AccountLibrarianStatusResult> implements AccountLibrarianStatusResultConverter {
    @Override
    public AccountLibrarianStatusResult convert(AccountLibrarianStatus param) {
        AccountLibrarianStatusResult accountLibrarianStatusResult = new AccountLibrarianStatusResult();
        accountLibrarianStatusResult =convertStandart(param,accountLibrarianStatusResult);
        return accountLibrarianStatusResult;
    }

    @Override
    public AccountLibrarianStatusResult convertSpecific(AccountLibrarianStatus entity, AccountLibrarianStatusResult result) {
        return null;
    }
}
