package application.dataaccess.dao.accounttypedao;

import application.data.entity.AccountType;
import application.dataaccess.dao.common.commondao.BaseDaoJPAImpl;

public class AccountTypeDaoJPAImpl extends BaseDaoJPAImpl<AccountType,Long> implements AccountTypeDao {
    @Override
    public Class<AccountType> getMyType() {
        return AccountType.class;
    }
}
