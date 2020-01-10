package application.business.processor.bookstatusprocessor;

import application.business.converter.bookstatus.BookStatusParam;
import application.business.converter.bookstatus.BookStatusParamConverter;
import application.business.converter.bookstatus.BookStatusResult;
import application.business.converter.bookstatus.BookStatusResultConverter;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.BookStatus;
import application.dataaccess.dao.bookstatusdao.BookStatusDao;
import org.springframework.stereotype.Component;
@Component
public class BookStatusProcessorImpl
        extends BaseProcessorImpl<BookStatusParam,BookStatus,BookStatusResult,Long,
        BookStatusDao, BookStatusParamConverter, BookStatusResultConverter>
        implements BookStatusProcessor{

    @Override
    public Long getPK(BookStatusParam ent) {
        return  ent.getId();

    }
}
