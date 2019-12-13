package application.dataaccess.dao.accounttypedao;

import application.data.entity.AccountType;

import java.util.List;

public interface AccountTypeDao {
    AccountType save(AccountType entity);
    List<AccountType> save(List<AccountType> entity);

    AccountType update(AccountType entity);
    List<AccountType> update(List<AccountType> entity);

    void delete(Long id);
    void delete(AccountType entity);
    void delete(List<Long> idList);

    List<AccountType> find();
    AccountType find(Long id);

}