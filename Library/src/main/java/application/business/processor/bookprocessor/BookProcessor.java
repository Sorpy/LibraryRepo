package application.business.processor.bookprocessor;

import application.business.converter.book.BookParam;
import application.business.converter.book.BookResult;
import application.business.processor.common.BaseProcessor;

import java.util.List;

public interface BookProcessor extends BaseProcessor <BookParam ,BookResult, Long> {

}
