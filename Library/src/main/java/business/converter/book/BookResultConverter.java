package business.converter.book;

import business.converter.common.BaseResultConverter;
import data.entity.Book;

public interface BookResultConverter extends BaseResultConverter<Book,BookResult> {
    BookResult convert(Book param);
}
