package business.converter.book;

import business.converter.common.BaseResultConverterImpl;
import data.entity.Book;

public class BookResultConverterImpl extends BaseResultConverterImpl<Book,BookResult> implements BookResultConverter {
    @Override
    public BookResult convert(Book param) {
            BookResult bookResult = new BookResult();
            bookResult = convertStandart(param, bookResult);
            bookResult = convertSpecific(param, bookResult);
            return bookResult;
    }

        @Override
        public BookResult convertSpecific(Book entity, BookResult result) {
                result.setAuthorName(entity.getAuthor().getAuthorName());
                result.setBookStatusName(entity.getBookStatus().getName());
                result.setBookStatusId(entity.getBookStatus().getId());
                result.setDepartmentName(entity.getDepartment().getName());
                result.setGenreName(entity.getAuthor().getAuthorName());
                return result;
        }
}
