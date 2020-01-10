package application.dataaccess.dao.bookstatusdao;

import application.data.entity.BookStatus;
import application.dataaccess.dao.common.commondao.BaseDaoFileImpl;
public class BookStatusDaoImpl extends BaseDaoFileImpl<BookStatus,Long, BookStatusDataImpl> implements BookStatusDao {

    @Override
    public Long getPK(BookStatus bookStatus) {
        return bookStatus.getId();
    }
}
