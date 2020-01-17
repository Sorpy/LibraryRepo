package application.presentation.service.accounttype;

import application.business.converter.accounttype.AccountTypeParam;
import application.business.converter.accounttype.AccountTypeResult;
import application.business.processor.accounttypeprocessor.AccountTypeProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/AccountType")
public class AccountTypeServiceImpl
        extends BaseServiceImpl<AccountTypeParam, AccountTypeResult,Long, AccountTypeProcessor>
        implements AccountTypeService{

}
