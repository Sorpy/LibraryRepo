package application.dataaccess.dao.accountdao;

import application.data.entity.Account;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface AccountDao {
    Account save(Account entity);
    List<Account> save(List<Account> entity);

    Account update(Account entity);
    List<Account> update(List<Account> entity);

    void delete(Long id);
    void delete(Account entity);
    void delete(List<Long> idList);

    List<Account> find();
    Account find(Long id);
    List<Account> find(String name);
    List<Account> find(String name, String value) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, IntrospectionException, InvocationTargetException;

}
