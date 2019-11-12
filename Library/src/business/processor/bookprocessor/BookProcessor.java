package business.processor.bookprocessor;

import business.converter.book.BookParam;
import business.converter.book.BookResult;

import java.util.List;

public interface BookProcessor {
    BookResult create(BookParam param);
    List<BookResult> create(List<BookParam> param);

    void update(Long id,BookParam param);
    void update(List<BookParam> param);

    void delete(Long id);
    void delete(List<Long> idList);

    BookResult find(Long id);
    List<BookResult> find();
}
