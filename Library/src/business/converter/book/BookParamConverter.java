package business.converter.book;


import business.converter.common.BaseParamConverter;
import data.entity.Book;

public interface BookParamConverter extends BaseParamConverter<BookParam,Book> {
    Book convert(BookParam param, Book oldEntity);
}
