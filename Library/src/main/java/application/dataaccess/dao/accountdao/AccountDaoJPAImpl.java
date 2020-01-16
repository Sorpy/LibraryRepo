package application.dataaccess.dao.accountdao;

import application.data.entity.Account;
import application.dataaccess.dao.common.commondao.BaseDaoJPAImpl;


public class AccountDaoJPAImpl extends BaseDaoJPAImpl<Account,Long> implements AccountDao {
    @Override
    public Class<Account> getMyType() {
        return Account.class;
    }
}
