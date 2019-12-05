package application.dataaccess.dao.accountdao;

import application.data.entity.Account;
import application.dataaccess.dao.common.BaseStorage;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static application.dataaccess.dao.accountdao.AccountData.accounts;
import static application.dataaccess.dao.accountdao.AccountData.accountMap;
@Component
public class AccountDaoImpl implements AccountDao {
    //private AccountData accountClientData = new AccountData();
    @Override
    public Account save(Account entity) {
        accountMap.putIfAbsent(entity.getId(),entity);
        //accounts.add(entity);
        BaseStorage.saveToDataSource();
        return entity;
    }

    @Override
    public List<Account> save(List<Account> entity) {
        entity.forEach(this::save);

        return accounts;
    }

    @Override
    public Account update(Account entity) {
        delete(entity.getId());
        save(entity);
        return entity;
    }

    @Override
    public List<Account> update(List<Account> entity) {
        entity.forEach(this::update);
        return entity;
    }

    @Override
    public void delete(Long id) {
        Account removeEntity = find(id);
        delete(removeEntity);
        BaseStorage.saveToDataSource();
    }

    @Override
    public void delete(Account entity) {
        accountMap.remove(entity.getId(),entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<Account> find() {
        return new ArrayList<>(accountMap.values());
    }

    public List<Account> find(String name) {
        return new ArrayList<>(accountMap.values())
                .stream()
                .filter(e -> e.getFirstName().toLowerCase().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Account> find(String name, String value) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        List<Account> accountClientsFiltered = new ArrayList<>();
        Method method = Account.class.getMethod(name);

        for (Account account : new ArrayList<>(accountMap.values())) {
            String field = method.invoke(account).toString();
            if (field.toLowerCase().equals(value)){
                accountClientsFiltered.add(account);
            }
        }
        return accountClientsFiltered;
    }

    @Override
    public Account find(Long id) {
        return new ArrayList<>(accountMap.values())
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst().get();
    }
}
