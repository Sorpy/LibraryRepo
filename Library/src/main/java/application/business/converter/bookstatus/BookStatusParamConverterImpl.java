package application.business.converter.bookstatus;

import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.BookStatus;
import org.springframework.stereotype.Component;

@Component
public class BookStatusParamConverterImpl
        extends BaseParamConverterImpl<BookStatusParam,BookStatus>
        implements BookStatusParamConverter {




    @Override
    public void convertSpecific(BookStatusParam param, BookStatus entity) { }

    @Override
    public BookStatus getEntity(BookStatusParam param) {
        BookStatus bookStatus = new BookStatus();
        bookStatus.setCode(param.getCode());
        bookStatus.setId(param.getId());
        return bookStatus;
    }
}
