package dataaccess.dao.accountstatusdao;

import data.entity.AccountStatus;

import java.util.List;

public interface AccountStatusDao {
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
