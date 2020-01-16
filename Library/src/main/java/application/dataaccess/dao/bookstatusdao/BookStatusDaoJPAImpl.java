package application.dataaccess.dao.bookstatusdao;

import application.data.entity.BookStatus;
import application.dataaccess.dao.common.commondao.BaseDaoJPAImpl;

public class BookStatusDaoJPAImpl extends BaseDaoJPAImpl<BookStatus,Long> implements BookStatusDao {
    @Override
    public Class<BookStatus> getMyType() {
        return BookStatus.class;
    }
}
