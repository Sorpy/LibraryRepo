package business.converter.bookstatus;

import data.entity.BookStatus;

public class BookStatusResultConverterImpl implements BookStatusResultConverter{
    @Override
    public BookStatusResult convert(BookStatus param) {
        BookStatusResult bookStatusResult = new BookStatusResult();
        bookStatusResult.setCode(param.getCode());
        bookStatusResult.setName(param.getName());
        bookStatusResult.setDescription(param.getDescription());
        bookStatusResult.setId(param.getId());
        return bookStatusResult;
    }
}
