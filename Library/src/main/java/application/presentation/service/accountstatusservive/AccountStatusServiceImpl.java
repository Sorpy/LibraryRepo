package application.presentation.service.accountstatusservive;

import application.business.converter.accountstatus.AccountStatusParam;
import application.business.converter.accountstatus.AccountStatusResult;
import application.business.processor.accountstatusprocessor.AccountStatusProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/AccountStatus")
public class AccountStatusServiceImpl
        extends BaseServiceImpl<AccountStatusParam,AccountStatusResult,Long,AccountStatusProcessor>
        implements AccountStatusService {

}
