package dataaccess.dao.accountstatusdao;

import data.entity.AccountStatus;

import java.util.ArrayList;
import java.util.List;

import static dataaccess.dao.accountstatusdao.AccountStatusData.*;

public class AccountStatusDaoImpl implements AccountStatusDao {
    @Override
    public AccountStatus save(AccountStatus entity) {
            accountStatusMap.putIfAbsent(entity.getId(),entity);
        //accountStatuses.add(entity);

        return entity;
    }

    @Override
    public List<AccountStatus> save(List<AccountStatus> entity) {
        entity.forEach(this::save);
        return entity;
    }

    @Override
    public AccountStatus update(AccountStatus entity) {
        delete(entity.getId());
        save(entity);
        return entity;
    }

    @Override
    public List<AccountStatus> update(List<AccountStatus> entity) {
        entity.forEach(this::update);
        return entity;
    }

    @Override
    public void delete(Long id) {
        AccountStatus removeEntity = find(id);
        delete(removeEntity);
    }

    @Override
    public void delete(AccountStatus entity) {
        accountStatusMap.remove(entity.getId(),entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<AccountStatus> find() {
        return new ArrayList<>(accountStatusMap.values());
    }

    @Override
    public AccountStatus find(Long id) {
        return new ArrayList<>(accountStatusMap.values())
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
