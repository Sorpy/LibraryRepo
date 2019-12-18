package application.dataaccess.dao.accountstatusdao;

import application.data.entity.AccountStatus;
import application.dataaccess.dao.common.BaseDao;

import java.util.List;

public interface AccountStatusDao extends BaseDao<AccountStatus, Long> {
    AccountStatus save(AccountStatus entity);
    List<AccountStatus> save(List<AccountStatus> entity);

    AccountStatus update(AccountStatus entity);
    List<AccountStatus> update(List<AccountStatus> entity);

    void delete(Long id);
    void delete(AccountStatus entity);
    void delete(List<Long> idList);

    List<AccountStatus> find();
    AccountStatus find(Long id);

}
