package application.dataaccess.dao.accounttypedao;

import application.data.entity.AccountType;
import application.dataaccess.dao.common.commondao.BaseDaoFileImpl;
public class AccountTypeDaoImpl extends BaseDaoFileImpl<AccountType,Long, AccountTypeData>implements AccountTypeDao{

    @Override
    public Long getPK(AccountType accountType) {
        return accountType.getId();
    }
}
