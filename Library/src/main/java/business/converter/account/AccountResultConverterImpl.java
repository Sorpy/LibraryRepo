package business.converter.account;

import business.converter.common.BaseResultConverterImpl;
import data.entity.Account;


public class AccountResultConverterImpl extends BaseResultConverterImpl<Account,AccountResult> implements AccountResultConverter {


    @Override
    public AccountResult convert(Account param) throws IllegalAccessException {
        AccountResult accountClientResult = new AccountResult();
        accountClientResult =convertStandart(param,accountClientResult);
        accountClientResult = convertSpecific(param,accountClientResult);
        return accountClientResult;
    }

    @Override
    public AccountResult convertSpecific(Account entity, AccountResult result) {
        result.setUsername(entity.getUser().getUsername());
        result.setUserId(entity.getUser().getId());
        result.setAccountClientStatusName(entity.getAccountStatus().getName());
        result.setAccountClientStatusId(entity.getAccountStatus().getId());
        return result;
    }
}
