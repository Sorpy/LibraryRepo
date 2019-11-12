package dataaccess.dao.authordao;

import data.entity.Author;

import java.util.List;

public interface AuthorDao {
    Author save(Author entity);
    List<Author> save(List<Author> entity);

    Author update(Author entity);
    List<Author> update(List<Author> entity);

    void delete(Long id);
    void delete(Author entity);
    void delete(List<Long> idList);

    List<Author> find();
    Author find(Long id);
}
