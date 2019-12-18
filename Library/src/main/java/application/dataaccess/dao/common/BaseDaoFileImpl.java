package application.dataaccess.dao.common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.reflect.FieldUtils.*;

public abstract class BaseDaoFileImpl<ENT,PK> implements BaseDao<ENT,PK> {
    @Override
    public ENT save(ENT entity) {
        return null;
    }

    @Override
    public List<ENT> save(List<ENT> entity) {
        return null;
    }

    @Override
    public ENT update(ENT entity) {
        return null;
    }

    @Override
    public List<ENT> update(List<ENT> entity) {
        return null;
    }

    @Override
    public void deleteById(PK id) {

    }

    @Override
    public void delete(ENT entity) {

    }

    @Override
    public void delete(List<PK> idList) {

    }

    @Override
    public List<ENT> find() {
        return null;
    }

    @Override
    public ENT find(PK id) {
        return null;
    }

    @Override
    public List<ENT> find(String name, String value) throws IllegalAccessException {
        ArrayList<ENT> ents = new ArrayList<>();
        for ()
        for (Field field : getAllFieldsList(getEntity().getClass())) {
            field.setAccessible(true);
            String fieldValue = (String) readDeclaredField(getEntity(),name,true);
            if (field.getName().equals(name) && value.equals(fieldValue)){
                ents.add();
            }

        }
        return ents;
    }

    @Override
    public abstract ENT getEntity();
}
