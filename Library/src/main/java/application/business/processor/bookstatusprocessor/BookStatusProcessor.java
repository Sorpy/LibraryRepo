package application.business.processor.bookstatusprocessor;

import application.business.converter.bookstatus.BookStatusParam;
import application.business.converter.bookstatus.BookStatusResult;
import application.business.processor.common.BaseProcessor;

import java.util.List;

public interface BookStatusProcessor extends BaseProcessor<BookStatusParam,BookStatusResult, Long> {
}
