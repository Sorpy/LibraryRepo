package application.business.processor.accountprocessor;

import application.business.converter.account.AccountParam;
import application.business.converter.account.AccountResult;
import application.business.processor.common.BaseProcessor;

public interface AccountProcessor extends BaseProcessor<AccountParam, AccountResult,Long> {
}
