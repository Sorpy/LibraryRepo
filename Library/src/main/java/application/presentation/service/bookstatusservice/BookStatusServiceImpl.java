package application.presentation.service.bookstatusservice;

import application.business.converter.bookstatus.BookStatusParam;
import application.business.converter.bookstatus.BookStatusResult;
import application.business.processor.bookstatusprocessor.BookStatusProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
@Component
public class BookStatusServiceImpl extends BaseServiceImpl<BookStatusParam,BookStatusResult,Long,BookStatusProcessor> implements BookStatusService{

}
