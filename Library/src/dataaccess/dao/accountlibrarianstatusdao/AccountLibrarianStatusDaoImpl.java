package dataaccess.dao.accountlibrarianstatusdao;

import data.entity.AccountLibrarianStatus;

import java.util.List;

import static dataaccess.dao.accountlibrarianstatusdao.AccountLibrarianStatusData.*;

public class AccountLibrarianStatusDaoImpl implements AccountLibrarianStatusDao{
    @Override
    public AccountLibrarianStatus save(AccountLibrarianStatus entity) {
        accountLibrarianStatusMap.putIfAbsent(entity.getId(), entity);
        accountLibrarianStatuses.add(entity);

        return entity;
    }

    @Override
    public List<AccountLibrarianStatus> save (List<AccountLibrarianStatus> entity) {
        accountLibrarianStatuses.addAll(entity);
        return entity;
    }

    @Override
    public AccountLibrarianStatus update(AccountLibrarianStatus entity) {
        delete(entity.getId());
        accountLibrarianStatuses.add(entity);
        return entity;
    }

    @Override
    public List<AccountLibrarianStatus> update(List<AccountLibrarianStatus> entity) {
        return null;
    }

    @Override
    public void delete(Long id) {
        AccountLibrarianStatus removeEntity = find(id);
        delete(removeEntity);
    }

    @Override
    public void delete(AccountLibrarianStatus entity) {
        accountLibrarianStatuses.remove(entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<AccountLibrarianStatus> find() {
        return accountLibrarianStatuses;
    }

    @Override
    public AccountLibrarianStatus find(Long id) {
        return accountLibrarianStatuses
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
