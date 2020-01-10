package application.dataaccess.dao.accountdao;

import application.data.entity.Account;
import application.dataaccess.dao.common.commondao.BaseDaoFileImpl;


public class AccountDaoFileImpl extends BaseDaoFileImpl<Account,Long,AccountData> implements AccountDao {
    @Override
    public Long getPK(Account account) {
        return account.getId();
    }
}
