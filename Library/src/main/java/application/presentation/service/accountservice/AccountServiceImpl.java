package application.presentation.service.accountservice;

import application.business.converter.account.AccountParam;
import application.business.converter.account.AccountResult;
import application.business.processor.accountprocessor.AccountProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
@Component
public class AccountServiceImpl
        extends BaseServiceImpl<AccountParam,AccountResult,Long,AccountProcessor>
        implements AccountService {

}
