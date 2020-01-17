package application.presentation.service.bookservice;

import application.business.converter.book.BookParam;
import application.business.converter.book.BookResult;
import application.business.processor.bookprocessor.BookProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/Book")
public class BookServiceImpl extends BaseServiceImpl<BookParam,BookResult,Long,BookProcessor> implements BookService{

}
