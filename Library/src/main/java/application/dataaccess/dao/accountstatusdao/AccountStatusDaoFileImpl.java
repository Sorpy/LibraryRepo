package application.dataaccess.dao.accountstatusdao;

import application.data.entity.AccountStatus;
import application.dataaccess.dao.common.commondao.BaseDaoFileImpl;
public class AccountStatusDaoFileImpl extends BaseDaoFileImpl<AccountStatus,Long, AccountStatusData> implements AccountStatusDao {
    @Override
    public Long getPK(AccountStatus accountStatus) {
        return accountStatus.getId();
    }
}
