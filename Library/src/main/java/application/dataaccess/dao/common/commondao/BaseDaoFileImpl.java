package application.dataaccess.dao.common.commondao;

import application.data.common.Persistent;
import application.dataaccess.dao.common.commonstorage.BaseStorage;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.reflect.FieldUtils.getAllFieldsList;
import static org.apache.commons.lang3.reflect.FieldUtils.readDeclaredField;


public abstract class BaseDaoFileImpl<ENT extends Persistent,PK,STORAGE extends BaseStorage> implements BaseDao<ENT,PK> {
    @Autowired
    private STORAGE storage;

    @Override
    public ENT save(ENT entity) {
        storage.getMap().putIfAbsent(getPK(entity),entity);
        storage.saveToDataSource();
        return entity;
    }

    @Override
    public List<ENT> save(List<ENT> entList) {
        entList.forEach(this::save);

        return entList;
    }

    @Override
    public ENT update(ENT entity) {
        deleteById (getPK(entity));
        save(entity);
        return entity;
    }

    @Override
    public List<ENT> update(List<ENT> entList) {
        entList.forEach(this::update);
        return entList;
    }

    @Override
    public void deleteById(PK id) {
        ENT removeEntity = find(id);
        delete(removeEntity);
        storage.saveToDataSource();
    }

    @Override
    public void delete(ENT entity) {
        storage.getMap().remove(getPK(entity),entity);
    }

    @Override
    public void delete(List<PK> idList) {
        idList.forEach(this::deleteById);
    }

    @Override
    public List<ENT> find() {
        return new ArrayList<>(storage.getMap().values());    }

    @Override
    public ENT find(PK id) {
        return new ArrayList<ENT>(storage.getMap().values())
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst().get();
    }

    @Override
    public List<ENT> find(String name, String value){
        ArrayList<ENT> ents = new ArrayList<>();
        ArrayList<ENT> entities = (ArrayList<ENT>) storage.getMap().values();
        entities.forEach(ent -> {
            for (Field field : getAllFieldsList(ent.getClass())) {
                field.setAccessible(true);
                String fieldValue = null;
                try {
                    fieldValue = (String) readDeclaredField(ent, name, true);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (field.getName().equals(name) && value.equals(fieldValue)) {
                    ents.add(ent);
                }
            }
        });
        return ents;
    }
    public abstract PK getPK (ENT ent);
}