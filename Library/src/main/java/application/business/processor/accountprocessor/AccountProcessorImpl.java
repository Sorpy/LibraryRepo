package application.business.processor.accountprocessor;

import application.business.converter.account.*;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.Account;
import application.dataaccess.dao.accountdao.AccountDao;

import org.springframework.stereotype.Component;

@Component
public class AccountProcessorImpl
        extends BaseProcessorImpl<AccountParam, Account, AccountResult,Long,
        AccountDao, AccountParamConverter, AccountResultConverter>
        implements AccountProcessor {


    @Override
    public Long getPK(AccountParam ent) {
        return ent.getId();
    }
}
