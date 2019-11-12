package dataaccess.dao.accountlibrariandao;

import data.entity.AccountLibrarian;

import java.util.List;
import java.util.stream.Collectors;

import static dataaccess.dao.accountlibrariandao.AccountLibrarianData.*;

public class AccountLibrarianDaoImpl implements AccountLibrarianDao {
    @Override
    public AccountLibrarian save(AccountLibrarian entity) {
        accountLibrarians.add(entity);
        accountLibrarianMap.putIfAbsent(entity.getId(),entity);
        return entity;
    }

    @Override
    public List<AccountLibrarian> save(List<AccountLibrarian> entity) {
        accountLibrarians.addAll(entity);
        return entity;
    }

    @Override
    public AccountLibrarian update(AccountLibrarian entity) {
        delete(entity.getId());
        accountLibrarians.add(entity);
        return entity;
    }

    @Override
    public List<AccountLibrarian> update(List<AccountLibrarian> entity) {
        return null;
    }

    @Override
    public void delete(Long id) {
        AccountLibrarian removeEntity = find(id);
        delete(removeEntity);
    }

    @Override
    public void delete(AccountLibrarian entity) {
        accountLibrarians.remove(entity);
    }

    @Override
    public void delete(List<Long> idList)  {
        idList.forEach(this::delete);
    }

    @Override
    public List<AccountLibrarian> find() {
        return accountLibrarians;
    }

    @Override
    public AccountLibrarian find(Long id) {
        return accountLibrarians
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst().get();
    }

    @Override
    public List<AccountLibrarian> find (String name){
        return accountLibrarians
                .stream()
                .filter(e -> e.getFirstName().toLowerCase().equals(name))
                .collect(Collectors.toList());
    }

}
