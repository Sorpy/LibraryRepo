package application.business.processor.accountstatusprocessor;

import application.business.converter.accountstatus.AccountStatusParam;
import application.business.converter.accountstatus.AccountStatusParamConverter;
import application.business.converter.accountstatus.AccountStatusResult;
import application.business.converter.accountstatus.AccountStatusResultConverter;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.AccountStatus;
import application.dataaccess.dao.accountstatusdao.AccountStatusDao;
import org.springframework.stereotype.Component;
@Component
public class AccountStatusProcessorImpl
        extends BaseProcessorImpl<AccountStatusParam,AccountStatus,AccountStatusResult,Long,
        AccountStatusDao,AccountStatusParamConverter,AccountStatusResultConverter>
        implements AccountStatusProcessor {

    @Override
    public Long getPK(AccountStatusParam ent) {
        return ent.getId();
    }
}
