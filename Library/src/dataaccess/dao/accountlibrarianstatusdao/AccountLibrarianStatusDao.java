package dataaccess.dao.accountlibrarianstatusdao;

import data.entity.AccountLibrarianStatus;

import java.util.List;

public interface AccountLibrarianStatusDao {
    AccountLibrarianStatus save(AccountLibrarianStatus entity);
    List<AccountLibrarianStatus> save(List<AccountLibrarianStatus> entity);

    AccountLibrarianStatus update(AccountLibrarianStatus entity);
    List<AccountLibrarianStatus> update(List<AccountLibrarianStatus> entity);

    void delete(Long id);
    void delete(AccountLibrarianStatus entity);
    void delete(List<Long> idList);

    List<AccountLibrarianStatus> find();
    AccountLibrarianStatus find(Long id);
}
