package application.dataaccess.dao.bookdao;

import application.data.entity.Book;
import application.dataaccess.dao.common.commondao.BaseDaoFileImpl;
public class BookDaoImpl extends BaseDaoFileImpl<Book,Long, BookDataImpl> implements BookDao{

    @Override
    public Long getPK(Book book) {
        return book.getId();
    }
}
