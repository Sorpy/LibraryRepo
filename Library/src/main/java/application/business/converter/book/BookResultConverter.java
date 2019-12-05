package application.business.converter.book;

import application.business.converter.common.BaseResultConverter;
import application.data.entity.Book;

public interface BookResultConverter extends BaseResultConverter<Book,BookResult> {
    BookResult convert(Book param);
}
