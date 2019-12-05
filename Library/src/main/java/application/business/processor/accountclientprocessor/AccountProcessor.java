package application.business.processor.accountclientprocessor;

import application.business.converter.account.AccountParam;
import application.business.converter.account.AccountResult;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface AccountProcessor {
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
