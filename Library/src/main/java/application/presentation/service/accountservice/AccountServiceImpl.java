package application.presentation.service.accountservice;

import application.business.converter.account.AccountParam;
import application.business.converter.account.AccountResult;
import application.business.processor.accountprocessor.AccountProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/Account")
public class AccountServiceImpl
        extends BaseServiceImpl<AccountParam,AccountResult,Long,AccountProcessor>
        implements AccountService {

}
