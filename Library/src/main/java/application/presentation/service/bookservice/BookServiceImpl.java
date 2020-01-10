package application.presentation.service.bookservice;

import application.business.converter.book.BookParam;
import application.business.converter.book.BookResult;
import application.business.processor.bookprocessor.BookProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
@Component
public class BookServiceImpl extends BaseServiceImpl<BookParam,BookResult,Long,BookProcessor> implements BookService{

}
