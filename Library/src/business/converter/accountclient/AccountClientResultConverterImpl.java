package business.converter.accountclient;

import business.converter.common.BaseResultConverterImpl;
import data.entity.AccountClient;


public class AccountClientResultConverterImpl extends BaseResultConverterImpl<AccountClient,AccountClientResult> implements AccountClientResultConverter {


    @Override
    public AccountClientResult convert(AccountClient param) throws IllegalAccessException {
        AccountClientResult accountClientResult = new AccountClientResult();
        accountClientResult =convertStandart(param,accountClientResult);
        accountClientResult = convertSpecific(param,accountClientResult);
        return accountClientResult;
    }

    @Override
    public AccountClientResult convertSpecific(AccountClient entity, AccountClientResult result) {
        result.setUsername(entity.getUser().getUsername());
        result.setUserId(entity.getUser().getId());
        result.setAccountClientStatusName(entity.getAccountClientStatus().getName());
        result.setAccountClientStatusId(entity.getAccountClientStatus().getId());
        return result;
    }
}
