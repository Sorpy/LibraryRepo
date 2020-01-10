package application.business.processor.bookprocessor;

import application.business.converter.book.*;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.Book;
import application.dataaccess.dao.bookdao.BookDao;
import org.springframework.stereotype.Component;

@Component
public class BookProcessorImpl
        extends BaseProcessorImpl<BookParam,Book,BookResult,Long,
        BookDao, BookParamConverter, BookResultConverter>
        implements BookProcessor{

    @Override
    public Long getPK(BookParam ent) {
        return  ent.getId();

    }
}
