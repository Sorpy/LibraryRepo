package application.business.processor.common;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface BaseProcessor <IN,OUT,PK> {
    OUT create(IN param) throws JsonProcessingException, IllegalAccessException;
    List<OUT> create(List<IN> param) throws JsonProcessingException;

    void update(PK id, IN param);
    void update(List<IN> param);

    void erase(PK id);
    void erase(List<PK> idList);

    void delete(PK id);
    void delete(List<PK> idList);

    OUT find(PK id) throws JsonProcessingException, IllegalAccessException;
    List<OUT> find() throws JsonProcessingException;
    List<OUT> find(String name, String value) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, IntrospectionException, InvocationTargetException;
}
