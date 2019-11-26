package business.converter.bookstatus;

import business.converter.common.BaseParamConverter;
import business.converter.common.BaseResultConverter;
import data.entity.Book;
import data.entity.BookStatus;

public interface BookStatusParamConverter extends BaseParamConverter<BookStatusParam,BookStatus> {

    BookStatus convert(BookStatusParam param, BookStatus oldEntity);
}
