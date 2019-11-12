package dataaccess.dao.accountlibrariandao;

import data.entity.AccountLibrarian;

import java.util.List;

public interface AccountLibrarianDao {
    AccountLibrarian save(AccountLibrarian entity);
    List<AccountLibrarian> save(List<AccountLibrarian> entity);

    AccountLibrarian update(AccountLibrarian entity);
    List<AccountLibrarian> update(List<AccountLibrarian> entity);

    void delete(Long id);
    void delete(AccountLibrarian entity);
    void delete(List<Long> idList);

    List<AccountLibrarian> find();
    AccountLibrarian find(Long id);
    List<AccountLibrarian> find(String name);
}
