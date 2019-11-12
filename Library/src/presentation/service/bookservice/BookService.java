package presentation.service.bookservice;

import business.converter.book.BookParam;
import data.common.APIResponse;

import java.util.List;

public interface BookService {
    APIResponse findByPK(long id);
    APIResponse listAll();

    APIResponse create(BookParam param);
    APIResponse create(List<BookParam> param);

    APIResponse update(long id, BookParam param);
    APIResponse update(List<BookParam> param);

    APIResponse deleteById(long id);
    APIResponse delete(List<Long> idList);

    void validateParameters(BookParam param);
    void validateParameters(List<BookParam> param);
}
