package application.dataaccess.dao.bookdao;

import application.data.entity.Book;
import application.dataaccess.dao.common.BaseDao;

import java.util.List;

public interface BookDao extends BaseDao<Book, Long> {
    Book save(Book entity);
    List<Book> save(List<Book> entity);

    Book update(Book entity);
    List<Book> update(List<Book> entity);

    void delete(Long id);
    void delete(Book entity);
    void delete(List<Long> idList);

    List<Book> find();
    Book find(Long id);
}
