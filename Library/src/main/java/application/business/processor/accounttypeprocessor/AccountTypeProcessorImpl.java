package application.business.processor.accounttypeprocessor;

import application.business.converter.accounttype.AccountTypeParam;
import application.business.converter.accounttype.AccountTypeParamConverter;
import application.business.converter.accounttype.AccountTypeResult;
import application.business.converter.accounttype.AccountTypeResultConverter;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.AccountType;
import application.dataaccess.dao.accounttypedao.AccountTypeDao;
import org.springframework.stereotype.Component;
@Component
public class AccountTypeProcessorImpl
        extends BaseProcessorImpl<AccountTypeParam,AccountType,AccountTypeResult,Long,
        AccountTypeDao,AccountTypeParamConverter,AccountTypeResultConverter>
        implements AccountTypeProcessor{

    @Override
    public Long getPK(AccountTypeParam ent) {
        return ent.getId();
    }
}

