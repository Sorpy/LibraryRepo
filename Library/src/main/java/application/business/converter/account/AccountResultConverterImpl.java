package application.business.converter.account;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountResultConverterImpl extends BaseResultConverterImpl<Account,AccountResult> implements AccountResultConverter {


    @Override
    public AccountResult getResult() {
        return new AccountResult();
    }

    @Override
    public void convertSpecific(Account entity, AccountResult result) {
        result.setUsername(entity.getUser().getUsername());
        result.setUserId(entity.getUser().getId());
        result.setAccountClientStatusName(entity.getAccountStatus().getName());
        result.setAccountClientStatusId(entity.getAccountStatus().getId());
    }
}
