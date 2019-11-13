package business.converter.bookstatus;

import business.converter.common.BaseResultConverterImpl;
import data.entity.BookStatus;

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
