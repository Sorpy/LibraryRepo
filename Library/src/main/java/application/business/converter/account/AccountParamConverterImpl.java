package application.business.converter.account;

import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.Account;
import application.dataaccess.dao.accountstatusdao.AccountStatusDao;
import application.dataaccess.dao.userdao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountParamConverterImpl extends BaseParamConverterImpl<AccountParam,Account> implements AccountParamConverter {
    @Autowired
    private AccountStatusDao accountStatusDao;
    @Autowired
    private UserDao userDao;



    @Override
    public Account getEntity(AccountParam param) {
        Account account = new Account();
        account.setId(param.getId());
        account.setCode(param.getCode());
        return account;
    }


    @Override
    public void convertSpecific(AccountParam param, Account entity) {
        entity.setUser(userDao.find(param.getUserId()));
        entity.setAccountStatus(accountStatusDao.find(param.getAccountStatusId()));
    }
}
