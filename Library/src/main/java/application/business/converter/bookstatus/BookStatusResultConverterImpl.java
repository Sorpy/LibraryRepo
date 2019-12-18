package application.business.converter.bookstatus;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.BookStatus;
import org.springframework.stereotype.Component;

@Component
public class BookStatusResultConverterImpl
        extends BaseResultConverterImpl<BookStatus,BookStatusResult>
        implements BookStatusResultConverter{

    @Override
    public void convertSpecific(BookStatus entity, BookStatusResult result) {

    }

    @Override
    public BookStatusResult getResult() {
        return new BookStatusResult();
    }
}
