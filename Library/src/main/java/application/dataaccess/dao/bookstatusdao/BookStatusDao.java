package application.dataaccess.dao.bookstatusdao;

import application.data.entity.BookStatus;
import application.dataaccess.dao.common.BaseDao;

import java.util.List;

public interface BookStatusDao extends BaseDao<BookStatus, Long> {
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
