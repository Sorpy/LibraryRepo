package application.dataaccess.dao.common.commondao;

import application.data.common.Persistent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.reflect.FieldUtils.getAllFieldsList;
import static org.apache.commons.lang3.reflect.FieldUtils.readDeclaredField;

@Repository
@Transactional
public abstract class BaseDaoJPAImpl<ENT extends Persistent, PK> implements BaseDao<ENT,PK> {

    @PersistenceContext
    private EntityManager entityManager;

    public abstract Class<ENT> getMyType();


    @Override
    public ENT save(ENT entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public List<ENT> save(List<ENT> entities) {
        entities.forEach(this::save);
        return entities;
    }

    @Override
    public ENT update(ENT entity) {
        entityManager.merge(entity);
        return entity;
    }

    @Override
    public List<ENT> update(List<ENT> entities) {
        entities.forEach(this::update);
        return entities;
    }

    @Override
    public void deleteById(PK id) {
        delete(
                find(id));
    }

    @Override
    public void delete(ENT entity) {
        entityManager.remove(entity);
    }

    @Override
    public void delete(List<PK> idList) {
        idList.forEach(this::deleteById);
    }

    @Override
    public List<ENT> findAll() {
        return (List<ENT>) entityManager.createQuery("FROM " + getMyType().getName()).getResultList();
    }

    @Override
    public ENT find(PK id) {
        return entityManager.find(getMyType(),id);
    }

    @Override
    public List<ENT> find(String name, String value) {
        ArrayList<ENT> entities = new ArrayList<>();
        findAll().forEach(ent -> {
            for (Field field : getAllFieldsList(ent.getClass())) {
                field.setAccessible(true);
                String fieldValue = null;
                try {
                    fieldValue = (String) readDeclaredField(ent, name, true);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (field.getName().equals(name) && value.equals(fieldValue)) {
                    entities.add(ent);
                }
            }
        });
        return entities;
    }
}
