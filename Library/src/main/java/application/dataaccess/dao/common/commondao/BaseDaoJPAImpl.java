package application.dataaccess.dao.common.commondao;

import application.data.common.Persistent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class BaseDaoJPAImpl<ENT extends Persistent, PK> implements BaseDao<ENT,PK> {

    private Session currentSession;

    private Transaction currentTransaction;

    private Class<ENT> clazz;

    private Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    private Session openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    private void closeCurrentSession() {
        currentSession.close();
    }

    private void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory(){
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        return meta.getSessionFactoryBuilder().build();
    }

    @Override
    public ENT save(ENT entity) {
        openCurrentSessionWithTransaction();
        currentSession.save(entity);
        closeCurrentSessionWithTransaction();
        return entity;
    }

    @Override
    public List<ENT> save(List<ENT> entList) {
        openCurrentSessionWithTransaction();
        entList.forEach(ent -> currentSession.save(ent));
        closeCurrentSessionWithTransaction();
        return entList;
    }

    @Override
    public ENT update(ENT entity) {
        openCurrentSessionWithTransaction();
        currentSession.update(entity);
        closeCurrentSessionWithTransaction();
        return entity;
    }

    @Override
    public List<ENT> update(List<ENT> entList) {
        entList.forEach(this::update);
        return entList;
    }

    @Override
    public void deleteById(PK id) {
        delete(find(id));
    }

    @Override
    public void delete(ENT entity) {
        openCurrentSessionWithTransaction();
        currentSession.save(entity);
        closeCurrentSessionWithTransaction();
    }

    @Override
    public void delete(List<PK> idList) {
        idList.forEach(this::deleteById);
    }

    @Override
    public List<ENT> find() {
        openCurrentSession();
        return (List<ENT>) currentSession.createQuery("FROM " + clazz.getName()).list();
    }

    @Override
    public ENT find(PK id) {
        openCurrentSession();
        ENT ent =currentSession.find(clazz,id);
        closeCurrentSession();
        return ent;
    }

    @Override
    public List<ENT> find(String name, String value) {
        return null;
    }
}
