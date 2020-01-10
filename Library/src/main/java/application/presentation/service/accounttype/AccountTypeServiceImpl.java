package application.presentation.service.accounttype;

import application.business.converter.accounttype.AccountTypeParam;
import application.business.converter.accounttype.AccountTypeResult;
import application.business.processor.accounttypeprocessor.AccountTypeProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class AccountTypeServiceImpl extends BaseServiceImpl<AccountTypeParam, AccountTypeResult,Long, AccountTypeProcessor> implements AccountTypeService{

}
