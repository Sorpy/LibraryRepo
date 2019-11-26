package business.converter.bookstatus;

import business.converter.common.BaseResultConverter;
import data.entity.BookStatus;

public interface BookStatusResultConverter extends BaseResultConverter<BookStatus,BookStatusResult> {
    BookStatusResult convert(BookStatus param);
}
