package application.business.converter.bookstatus;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.BookStatus;
import org.springframework.stereotype.Component;

@Component
public class BookStatusResultConverterImpl extends BaseResultConverterImpl<BookStatus,BookStatusResult> implements BookStatusResultConverter{
    @Override
    public BookStatusResult convert(BookStatus param) {
        BookStatusResult bookStatusResult = new BookStatusResult();
        bookStatusResult = convertStandart(param,bookStatusResult);
        return bookStatusResult;
    }

    @Override
    public BookStatusResult convertSpecific(BookStatus entity, BookStatusResult result) {
        return null;
    }
}