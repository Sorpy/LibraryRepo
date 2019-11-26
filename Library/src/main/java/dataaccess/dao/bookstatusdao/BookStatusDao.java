package dataaccess.dao.bookstatusdao;

import data.entity.BookStatus;

import java.util.List;

public interface BookStatusDao {
    BookStatus save(BookStatus entity);
    List<BookStatus> save(List<BookStatus> entity);

    BookStatus update(BookStatus entity);
    List<BookStatus> update(List<BookStatus> entity);

    void delete(Long id);
    void delete(BookStatus entity);
    void delete(List<Long> idList);

    List<BookStatus> find();
    BookStatus find(Long id);
}
