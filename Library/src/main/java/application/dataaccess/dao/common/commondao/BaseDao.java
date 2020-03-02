package application.dataaccess.dao.common.commondao;

import application.data.common.Persistent;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface BaseDao <ENT extends Persistent,PK>{
    ENT save(ENT entity);
    List<ENT> save(List<ENT> entList);

    ENT update(ENT entity);
    List<ENT> update(List<ENT> entList);

    void eraseById(PK id);
    void erase(ENT entity);
    void erase(List<PK> idList);

    void delete(PK id);
    void delete(ENT entity);
    void delete(List<PK> idList);

    List<ENT> findAll();
    ENT find(PK id);
    List<ENT> find(String name, String value) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, IntrospectionException, InvocationTargetException;

}
