package application.dataaccess.dao.accounttypedao;

import application.data.entity.AccountType;
import application.dataaccess.dao.accountstatusdao.AccountStatusData;
import application.dataaccess.dao.common.BaseStorage;

import java.util.ArrayList;
import java.util.List;


import static application.dataaccess.dao.accounttypedao.AccountTypeData.accountTypes;
import static application.dataaccess.dao.accounttypedao.AccountTypeData.accountTypeMap;

public class AccountTypeDaoImpl implements AccountTypeDao{
    @Override
    public AccountType save(AccountType entity) {
        accountTypeMap.putIfAbsent(entity.getId(),entity);
        //accountStatuses.add(entity);
        BaseStorage.saveToDataSource();

        return entity;
    }

    @Override
    public List<AccountType> save(List<AccountType> entity) {
        entity.forEach(this::save);
        return entity;
    }

    @Override
    public AccountType update(AccountType entity) {
        delete(entity.getId());
        save(entity);
        return entity;
    }

    @Override
    public List<AccountType> update(List<AccountType> entity) {
        entity.forEach(this::update);
        return entity;
    }

    @Override
    public void delete(Long id) {
        AccountType removeEntity = find(id);
        delete(removeEntity);
        BaseStorage.saveToDataSource();
    }

    @Override
    public void delete(AccountType entity) {
        accountTypeMap.remove(entity.getId(),entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<AccountType> find() {
        return new ArrayList<>(accountTypeMap.values());
    }

    @Override
    public AccountType find(Long id) {
        return new ArrayList<>(accountTypeMap.values())
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
