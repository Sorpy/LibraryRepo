package dataaccess.dao.accountclientdao;

import data.entity.AccountClient;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static dataaccess.dao.accountclientdao.AccountClientData.accountClients;
import static dataaccess.dao.accountclientdao.AccountClientData.accountClientsMap;

public class AccountClientDaoImpl implements AccountClientDao {
    @Override
    public AccountClient save(AccountClient entity) {
        accountClientsMap.putIfAbsent(entity.getId(),entity);
        accountClients.add(entity);
        return entity;
    }

    @Override
    public List<AccountClient> save(List<AccountClient> entity) {

        accountClients.addAll(entity);
        return accountClients;
    }

    @Override
    public AccountClient update(AccountClient entity) {
        delete(entity.getId());
        accountClients.add(entity);
        return entity;
    }

    @Override
    public List<AccountClient> update(List<AccountClient> entity) {
        return null;
    }

    @Override
    public void delete(Long id) {
        AccountClient removeEntity = find(id);
        delete(removeEntity);
    }

    @Override
    public void delete(AccountClient entity) {
        accountClients.remove(entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<AccountClient> find() {
        return accountClients;
    }

    public List<AccountClient> find(String name) {
        return accountClients
                .stream()
                .filter(e -> e.getFirstName().toLowerCase().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<AccountClient> find(String name, String value) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        List<AccountClient> accountClientsFiltered = new ArrayList<>();
        Method method = AccountClient.class.getMethod(name);

        for (AccountClient accountClient: accountClients) {
            String field = method.invoke(accountClient).toString();
            if (field.toLowerCase().equals(value)){
                accountClientsFiltered.add(accountClient);
            }
        }
        return accountClientsFiltered;
    }

    @Override
    public AccountClient find(Long id) {
        return accountClients
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst().get();
    }
}
