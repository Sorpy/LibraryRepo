package business.processor.accountclientprocessor;

import business.converter.accountclient.AccountParam;
import business.converter.accountclient.AccountResult;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface AccountClientProcessor {
    AccountResult create(AccountParam param) throws JsonProcessingException, IllegalAccessException;
    List<AccountResult> create(List<AccountParam> param) throws JsonProcessingException;

    void update(Long id,AccountParam param);
    void update(List<AccountParam> param);

    void delete(Long id);
    void delete(List<Long> idList);

    AccountResult find(Long id) throws JsonProcessingException, IllegalAccessException;
    List<AccountResult> find() throws JsonProcessingException;
    List<AccountResult> find(String name);
    List<AccountResult> find(String name, String value) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, IntrospectionException, InvocationTargetException;
}
