package application.business.processor.bookprocessor;

import application.business.converter.book.*;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.Book;
import application.dataaccess.dao.bookdao.BookDao;
import application.dataaccess.dao.bookdao.BookDaoImpl;
import application.dataaccess.dao.common.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class BookProcessorImpl
        extends BaseProcessorImpl<BookParam,Book,BookResult,Long,
        BookDao, BookParamConverter, BookResultConverter>
        implements BookProcessor{

}
