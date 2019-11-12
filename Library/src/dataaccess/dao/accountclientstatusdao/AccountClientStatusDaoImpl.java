package dataaccess.dao.accountclientstatusdao;

import data.entity.AccountClientStatus;

import java.util.List;

import static dataaccess.dao.accountclientstatusdao.AccountClientStatusData.*;

public class AccountClientStatusDaoImpl implements AccountClientStatusDao {
    @Override
    public AccountClientStatus save(AccountClientStatus entity) {
            accountClientStatusMap.putIfAbsent(entity.getId(),entity);
        accountClientStatuses.add(entity);

        return entity;
    }

    @Override
    public List<AccountClientStatus> save(List<AccountClientStatus> entity) {
        accountClientStatuses.addAll(entity);
        return entity;
    }

    @Override
    public AccountClientStatus update(AccountClientStatus entity) {
        delete(entity.getId());
        accountClientStatuses.add(entity);
        return entity;
    }

    @Override
    public List<AccountClientStatus> update(List<AccountClientStatus> entity) {
        return null;
    }

    @Override
    public void delete(Long id) {
        AccountClientStatus removeEntity = find(id);
        delete(removeEntity);
    }

    @Override
    public void delete(AccountClientStatus entity) {
        accountClientStatuses.remove(entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<AccountClientStatus> find() {
        return accountClientStatuses;
    }

    @Override
    public AccountClientStatus find(Long id) {
        return accountClientStatuses
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
