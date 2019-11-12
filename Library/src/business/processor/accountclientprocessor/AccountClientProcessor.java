package business.processor.accountclientprocessor;

import business.converter.accountclient.AccountClientParam;
import business.converter.accountclient.AccountClientResult;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface AccountClientProcessor {
    AccountClientResult create(AccountClientParam param) throws JsonProcessingException, IllegalAccessException;
    List<AccountClientResult> create(List<AccountClientParam> param) throws JsonProcessingException;

    void update(Long id,AccountClientParam param);
    void update(List<AccountClientParam> param);

    void delete(Long id);
    void delete(List<Long> idList);

    AccountClientResult find(Long id) throws JsonProcessingException, IllegalAccessException;
    List<AccountClientResult> find() throws JsonProcessingException;
    List<AccountClientResult> find(String name);
    List<AccountClientResult> find(String name, String value) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, IntrospectionException, InvocationTargetException;
}
