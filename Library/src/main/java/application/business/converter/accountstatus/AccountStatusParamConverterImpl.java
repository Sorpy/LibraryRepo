package application.business.converter.accountstatus;

import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.AccountStatus;
import org.springframework.stereotype.Component;

@Component
public class AccountStatusParamConverterImpl extends BaseParamConverterImpl<AccountStatusParam,AccountStatus> implements AccountStatusParamConverter {


    @Override
    public AccountStatus getEntity(AccountStatusParam param) {
        AccountStatus accountStatus = new AccountStatus();
        accountStatus.setId(param.getId());
        accountStatus.setCode(param.getCode());
        return accountStatus;
    }

    @Override
    public void convertSpecific(AccountStatusParam param, AccountStatus entity) { }
}
