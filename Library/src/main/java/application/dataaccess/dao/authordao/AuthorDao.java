package application.dataaccess.dao.authordao;

import application.data.entity.Author;
import application.dataaccess.dao.common.BaseDao;

import java.util.List;

public interface AuthorDao extends BaseDao<Author, Long> {
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
