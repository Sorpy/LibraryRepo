package application.dataaccess.dao.authordao;

import application.data.entity.Author;
import application.dataaccess.dao.common.BaseStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static application.dataaccess.dao.authordao.AuthorData.*;
@Component
public class AuthorDaoImpl implements AuthorDao {
    @Override
    public Author save(Author entity) {
        authorMap.putIfAbsent(entity.getId(), entity);
        //authors.add(entity);
        BaseStorage.saveToDataSource();
        return entity;
    }

    @Override
    public List<Author> save (List<Author> entity) {
        entity.forEach(this::save);
        return entity;
    }

    @Override
    public Author update(Author entity) {
        delete(entity.getId());
        save(entity);
        return entity;
    }

    @Override
    public List<Author> update(List<Author> entity) {
        entity.forEach(this::update);
        return entity;
    }

    @Override
    public void delete(Long id) {
        Author removeEntity = find(id);
        delete(removeEntity);
        BaseStorage.saveToDataSource();
    }

    @Override
    public void delete(Author entity) {
        authorMap.remove(entity.getId(),entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<Author> find() {
        return new ArrayList<>(authorMap.values());
    }

    @Override
    public Author find(Long id) {
        return new ArrayList<>(authorMap.values())
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
