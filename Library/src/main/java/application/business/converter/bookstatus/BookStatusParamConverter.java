package application.business.converter.bookstatus;

import application.business.converter.common.BaseParamConverter;
import application.data.entity.BookStatus;

public interface BookStatusParamConverter extends BaseParamConverter<BookStatusParam,BookStatus> {

    BookStatus convert(BookStatusParam param, BookStatus oldEntity);
}
