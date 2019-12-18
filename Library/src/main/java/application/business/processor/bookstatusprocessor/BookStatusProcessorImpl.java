package application.business.processor.bookstatusprocessor;

import application.business.converter.bookstatus.*;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.BookStatus;
import application.dataaccess.dao.bookstatusdao.BookStatusDao;
import application.dataaccess.dao.bookstatusdao.BookStatusDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class BookStatusProcessorImpl
        extends BaseProcessorImpl<BookStatusParam,BookStatus,BookStatusResult,Long,
        BookStatusDao, BookStatusParamConverter, BookStatusResultConverter>
        implements BookStatusProcessor{

}
