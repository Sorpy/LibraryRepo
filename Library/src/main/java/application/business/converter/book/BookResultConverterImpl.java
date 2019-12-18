package application.business.converter.book;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookResultConverterImpl extends BaseResultConverterImpl<Book,BookResult> implements BookResultConverter {

    @Override
    public void convertSpecific(Book entity, BookResult result) {
            result.setAuthorName(entity.getAuthor().getAuthorName());
            result.setBookStatusName(entity.getBookStatus().getName());
            result.setBookStatusId(entity.getBookStatus().getId());
            result.setDepartmentName(entity.getDepartment().getName());
            result.setGenreName(entity.getAuthor().getAuthorName());
    }

    @Override
    public BookResult getResult() {
        return new BookResult();
    }
}
