package application.business.processor.accountstatusprocessor;

import application.business.converter.accountstatus.*;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.AccountStatus;
import application.dataaccess.dao.accountstatusdao.AccountStatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AccountStatusProcessorImpl
        extends BaseProcessorImpl<AccountStatusParam,AccountStatus,AccountStatusResult,Long,
        AccountStatusDao,AccountStatusParamConverter,AccountStatusResultConverter>
        implements AccountStatusProcessor {

}
