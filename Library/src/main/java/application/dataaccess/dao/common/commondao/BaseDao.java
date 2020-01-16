package application.dataaccess.dao.common.commondao;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface BaseDao <ENT,PK>{
    ENT save(ENT entity);
    List<ENT> save(List<ENT> entList);

    ENT update(ENT entity);
    List<ENT> update(List<ENT> entList);

    void deleteById(PK id);
    void delete(ENT entity);
    void delete(List<PK> idList);

    List<ENT> findAll();
    ENT find(PK id);
    List<ENT> find(String name, String value) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, IntrospectionException, InvocationTargetException;

}
