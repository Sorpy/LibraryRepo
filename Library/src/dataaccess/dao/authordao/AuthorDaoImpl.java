package dataaccess.dao.authordao;

import data.entity.Author;

import java.util.List;

import static dataaccess.dao.authordao.AuthorData.*;

public class AuthorDaoImpl implements AuthorDao {
    @Override
    public Author save(Author entity) {
        authorMap.putIfAbsent(entity.getId(), entity);
        authors.add(entity);

        return entity;
    }

    @Override
    public List<Author> save (List<Author> entity) {
        authors.addAll(entity);
        return entity;
    }

    @Override
    public Author update(Author entity) {
        delete(entity.getId());
        authors.add(entity);
        return entity;
    }

    @Override
    public List<Author> update(List<Author> entity) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Author removeEntity = find(id);
        delete(removeEntity);
    }

    @Override
    public void delete(Author entity) {
        authors.remove(entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<Author> find() {
        return authors;
    }

    @Override
    public Author find(Long id) {
        return authors
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
