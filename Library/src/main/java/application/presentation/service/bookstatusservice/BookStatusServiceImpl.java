package application.presentation.service.bookstatusservice;

import application.business.converter.bookstatus.BookStatusParam;
import application.business.converter.bookstatus.BookStatusResult;
import application.business.processor.bookstatusprocessor.BookStatusProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/BookStatus")
public class BookStatusServiceImpl extends BaseServiceImpl<BookStatusParam,BookStatusResult,Long,BookStatusProcessor> implements BookStatusService{

}
