package business.processor.bookstatusprocessor;

import business.converter.bookstatus.BookStatusParam;
import business.converter.bookstatus.BookStatusResult;

import java.util.List;

public interface BookStatusProcessor {
    BookStatusResult create(BookStatusParam param);
    List<BookStatusResult> create(List<BookStatusParam> param);

    void update(Long id,BookStatusParam param);
    void update(List<BookStatusParam> param);

    void delete(Long id);
    void delete(List<Long> idList);

    BookStatusResult find(Long id);
    List<BookStatusResult> find();
}
