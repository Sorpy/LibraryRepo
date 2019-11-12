package dataaccess.dao.accountclientdao;

import data.entity.AccountClient;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface AccountClientDao {
    AccountClient save(AccountClient entity);
    List<AccountClient> save(List<AccountClient> entity);

    AccountClient update(AccountClient entity);
    List<AccountClient> update(List<AccountClient> entity);

    void delete(Long id);
    void delete(AccountClient entity);
    void delete(List<Long> idList);

    List<AccountClient> find();
    AccountClient find(Long id);
    List<AccountClient> find(String name);
    List<AccountClient> find(String name,String value) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, IntrospectionException, InvocationTargetException;

}
